package com.example.hiltmultimodulesample.di.deps_impl

import androidx.navigation.NavController
import com.example.screen_one.Screen1FragmentDirections
import com.example.screen_one.ScreenOneDeps
import javax.inject.Inject

class ScreenOneDepsImpl @Inject constructor(
    private val navController: NavController
) : ScreenOneDeps {

    override fun navigateToAnotherScreen() {
        val action = Screen1FragmentDirections.actionScreen1FragmentToScreen2Fragment()
        navController.navigate(action)
    }
}