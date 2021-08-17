package com.example.cloudy.di

import com.example.cloudy.CloudyApp
import com.example.cloudy.domain.AppRepository
import com.example.cloudy.domain.AppRepositoryImp
import com.example.cloudy.domain.usecase.GetCurrentWeatherUseCase
import com.example.cloudy.domain.usecase.GetDailyForecastUseCase
import com.example.cloudy.ui.viewmodels.LocationWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        CloudyApp().applicationContext
    }

    single<AppRepository> {
        AppRepositoryImp(get())
    }

    factory { GetCurrentWeatherUseCase(get()) }
    factory { GetDailyForecastUseCase(get()) }

    viewModel {
        LocationWeatherViewModel(get(), get())
    }
}