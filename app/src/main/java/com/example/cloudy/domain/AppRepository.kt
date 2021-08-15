package com.example.cloudy.domain.usecase

import com.example.cloudy.source.api.model.Forecast
import com.example.cloudy.source.api.model.Location

interface AppRepository {

    suspend fun getCurrentWeather(city: String, countryCode: String): Array<Location>

    suspend fun getDailyForecast(city: String, countryCode: String): Array<Forecast>
}