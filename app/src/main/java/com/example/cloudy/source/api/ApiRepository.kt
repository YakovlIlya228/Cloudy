package com.example.cloudy.source.api

import com.example.cloudy.source.api.model.ApiModel
import com.example.cloudy.source.api.model.Country
import com.example.cloudy.source.api.model.Forecast
import com.example.cloudy.source.api.model.Location

interface ApiRepository {

    suspend fun getCurrentWeather(city: String, countryCode: String): ApiModel<Array<Location>>

    suspend fun getDailyForecast(city: String, countryCode: String): ApiModel<Array<Forecast>>

    suspend fun getAllCountries(): ApiModel<Array<Country>>

}