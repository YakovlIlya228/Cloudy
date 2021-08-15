package com.example.cloudy

import android.app.Application
import com.example.cloudy.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CloudyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CloudyApp)
            modules(appModule)
        }
    }

}