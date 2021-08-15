package com.example.cloudy.domain.usecase

import com.example.cloudy.source.api.model.Location
import kotlin.properties.Delegates

class GetCurrentWeatherUseCase(
    private val appRepository: AppRepository
) : UseCase<Location>() {

    var city by Delegates.notNull<String>()
    var countryCode by Delegates.notNull<String>()

    override suspend fun executeOnBackground(): Location {
        return appRepository.getCurrentWeather(city, countryCode)[0]
    }
}