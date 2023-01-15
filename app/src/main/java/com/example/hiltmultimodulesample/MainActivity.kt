package com.example.hiltmultimodulesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.common.viewbinding.viewBinding
import com.example.hiltmultimodulesample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}