package com.example.cloudy.source.api

import com.example.cloudy.source.api.model.ApiModel
import com.example.cloudy.source.api.model.Forecast
import com.example.cloudy.source.api.model.Location

class ApiRepositoryImp(private val apiService: ApiService) : ApiRepository {

    override suspend fun getCurrentWeather(
        city: String,
        countryCode: String
    ): ApiModel<Array<Location>> {
        return apiService.getCurrentWeather(city, countryCode)
    }

    override suspend fun getDailyForecast(
        city: String,
        countryCode: String
    ): ApiModel<Array<Forecast>> {
        return apiService.getDailyForecast(city, countryCode)
    }
}