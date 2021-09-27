package com.example.cloudy.di

import android.content.Context
import android.content.SharedPreferences
import com.example.cloudy.source.DataConfig
import com.example.cloudy.source.pref.PreferencesRepository
import com.example.cloudy.source.pref.PreferencesRepositoryImp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferencesModule = module {

    single<SharedPreferences> {
        androidContext().getSharedPreferences(DataConfig.PREF_NAME, Context.MODE_PRIVATE)
    }

    single<PreferencesRepository> {
        PreferencesRepositoryImp(get())
    }

}