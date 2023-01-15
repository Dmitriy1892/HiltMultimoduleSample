package com.example.common.ui

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

fun EditText.setAfterTextChangedListenerWithDebounce(
    debounceMillis: Long = 300L,
    coroutineScope: CoroutineScope,
    actionBeforeDebounce: (suspend () -> Unit)? = null,
    actionAfterDebounce: suspend (text: String) -> Unit
): Job {
    val flow = callbackFlow<CharSequence?> {
        val listener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

            override fun afterTextChanged(s: Editable?) {
                trySend(s)
            }
        }
        addTextChangedListener(listener)
        awaitClose { removeTextChangedListener(listener) }
    }

    return flow
        .onEach { actionBeforeDebounce?.invoke() }
        .debounce(debounceMillis)
        .map { it?.toString() }
        .onEach { actionAfterDebounce(it ?: "") }
        .launchIn(coroutineScope)
}

fun <T> Flow<T>.observeWithLifecycle(
    lifecycle: Lifecycle,
    action: suspend (T) -> Unit
): Job {
    return this
        .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
        .onEach(action)
        .launchIn(lifecycle.coroutineScope)
}