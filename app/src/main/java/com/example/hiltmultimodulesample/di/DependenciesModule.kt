package com.example.hiltmultimodulesample.di

import com.example.hiltmultimodulesample.di.deps_impl.ScreenOneDepsImpl
import com.example.hiltmultimodulesample.di.deps_impl.ScreenTwoDepsImpl
import com.example.screen_one.ScreenOneDeps
import com.example.screen_two.ScreenTwoDeps
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface DependenciesModule {

    @Binds
    fun bindScreenOneDeps(screenOneDepsImpl: ScreenOneDepsImpl): ScreenOneDeps

    @Binds
    fun bindScreenTwoDeps(screenTwoDepsImpl: ScreenTwoDepsImpl): ScreenTwoDeps
}