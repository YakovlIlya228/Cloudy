package com.example.cloudy.domain.usecase

import com.example.cloudy.domain.AppRepository
import com.example.cloudy.source.api.model.Forecast
import kotlin.properties.Delegates

class GetDailyForecastUseCase(
    private val appRepository: AppRepository
) : UseCase<Array<Forecast>>() {

    var city by Delegates.notNull<String>()
    var countryCode by Delegates.notNull<String>()

    override suspend fun executeOnBackground(): Array<Forecast> {
        return appRepository.getDailyForecast(city, countryCode)
    }
}