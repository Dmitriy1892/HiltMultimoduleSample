package com.example.screen_two

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.common.delegates.viewBinding
import com.example.screen_two.databinding.FragmentScreen2Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Screen2Fragment : Fragment(R.layout.fragment_screen2) {

    @Inject
    lateinit var deps: dagger.Lazy<ScreenTwoDeps>

    private val binding: FragmentScreen2Binding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvInfo.setOnClickListener {
            binding.tvInfo.isEnabled = false

            deps.get().backToFirstScreen()
        }
    }

    override fun onStart() {
        super.onStart()

        binding.tvInfo.isEnabled = true
    }
}