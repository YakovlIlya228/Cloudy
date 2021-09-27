package com.example.cloudy.domain

import com.example.cloudy.source.api.model.Country
import com.example.cloudy.source.api.model.Forecast
import com.example.cloudy.source.api.model.Location

interface AppRepository {

    suspend fun getCurrentWeather(city: String, countryCode: String): Array<Location>

    suspend fun getDailyForecast(city: String, countryCode: String): Array<Forecast>

    suspend fun getAllCountries(): Array<Country>
}