package com.example.cloudy.di

import android.content.Context
import com.example.cloudy.CloudyApp
import org.koin.dsl.module

val appModule = module {

    fun getContext(): Context = CloudyApp().applicationContext
}