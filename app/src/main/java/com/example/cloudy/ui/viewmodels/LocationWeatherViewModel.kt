package com.example.cloudy.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cloudy.domain.usecase.GetCurrentWeatherUseCase
import com.example.cloudy.domain.usecase.GetDailyForecastUseCase
import com.example.cloudy.source.api.model.Forecast
import com.example.cloudy.source.api.model.Location

class LocationWeatherViewModel(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getDailyForecastUseCase: GetDailyForecastUseCase,
) : ViewModel() {

    val currentLocationWeather by lazy { MutableLiveData<Location>() }
    val dailyWeatherForecast by lazy { MutableLiveData<Array<Forecast>>() }

    fun fetchCurrentWeather(
        city: String,
        countryCode: String
    ) {
        getCurrentWeatherUseCase.apply {
            this.city = city
            this.countryCode = countryCode
        }.execute {
            onComplete {
                currentLocationWeather.postValue(it)
            }
        }
    }

    fun fetchDailyForecast(
        city: String,
        countryCode: String
    ) {
        getDailyForecastUseCase.apply {
            this.city = city
            this.countryCode = countryCode
        }.execute {
            onComplete {
                dailyWeatherForecast.postValue(it)
            }
        }
    }
}