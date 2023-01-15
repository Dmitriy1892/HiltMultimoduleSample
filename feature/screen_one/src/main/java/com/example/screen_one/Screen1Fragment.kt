package com.example.screen_one

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.common.delegates.viewBinding
import com.example.screen_one.R
import com.example.screen_one.databinding.FragmentScreen1Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Screen1Fragment : Fragment(R.layout.fragment_screen1) {

    @Inject
    lateinit var deps: dagger.Lazy<ScreenOneDeps>

    private val binding by viewBinding<FragmentScreen1Binding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvText1.setOnClickListener {
            binding.tvText1.isClickable = false
            deps.get().navigateToAnotherScreen()
        }
    }

    override fun onStart() {
        super.onStart()

        binding.tvText1.isClickable = true
    }
}