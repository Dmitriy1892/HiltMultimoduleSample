package com.example.hiltmultimodulesample.di.deps_impl

import androidx.navigation.NavController
import com.example.screen_two.ScreenTwoDeps
import javax.inject.Inject

class ScreenTwoDepsImpl @Inject constructor(
    private val navController: NavController
) : ScreenTwoDeps {

    override fun backToFirstScreen() {
        navController.popBackStack()
    }
}