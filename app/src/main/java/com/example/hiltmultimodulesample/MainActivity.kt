package com.example.hiltmultimodulesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltmultimodulesample.databinding.ActivityMainBinding
import com.example.hiltmultimodulesample.delegates.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
    }
}