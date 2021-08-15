package com.example.cloudy.domain.usecase

import com.example.cloudy.source.api.ApiRepository
import com.example.cloudy.source.api.model.Forecast
import com.example.cloudy.source.api.model.Location

class AppRepositoryImp(
    private val apiRepository: ApiRepository
) : AppRepository {

    override suspend fun getCurrentWeather(city: String, countryCode: String): Array<Location> {
        return apiRepository.getCurrentWeather(city, countryCode)
    }

    override suspend fun getDailyForecast(city: String, countryCode: String): Array<Forecast> {
        return apiRepository.getDailyForecast(city, countryCode)
    }
}