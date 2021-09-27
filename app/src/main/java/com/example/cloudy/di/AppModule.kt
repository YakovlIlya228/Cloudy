package com.example.cloudy.di

import android.app.Application
import com.example.cloudy.CloudyApp
import com.example.cloudy.domain.AppRepository
import com.example.cloudy.domain.AppRepositoryImp
import com.example.cloudy.domain.usecase.GetAllCountriesUseCase
import com.example.cloudy.domain.usecase.GetCurrentWeatherUseCase
import com.example.cloudy.domain.usecase.GetDailyForecastUseCase
import com.example.cloudy.ui.viewmodels.LocationWeatherViewModel
import com.example.cloudy.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    single<Application> { CloudyApp() }

    single<AppRepository> {
        AppRepositoryImp(get())
    }

    factory { GetCurrentWeatherUseCase(get()) }
    factory { GetDailyForecastUseCase(get()) }
    factory { GetAllCountriesUseCase(get(), get(), get()) }

    viewModel { LocationWeatherViewModel(get(), get()) }
    viewModel { MainViewModel(get()) }

}