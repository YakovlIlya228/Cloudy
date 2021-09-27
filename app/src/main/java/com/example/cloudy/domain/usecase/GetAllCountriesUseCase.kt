package com.example.cloudy.domain.usecase

import com.example.cloudy.domain.AppRepository
import com.example.cloudy.source.api.model.Country
import com.example.cloudy.source.db.DbRepository
import com.example.cloudy.source.pref.PreferencesRepository

class GetAllCountriesUseCase(
    private val appRepository: AppRepository,
    private val preferencesRepository: PreferencesRepository,
    private val dbRepository: DbRepository,
) : UseCase<Array<Country>?>() {

    override suspend fun executeOnBackground(): Array<Country>? {
        if (System.currentTimeMillis() - preferencesRepository.getCountriesLastFetchTime() > 604800) {
            dbRepository.saveCountriesToDb(appRepository.getAllCountries())
        }
        return dbRepository.getCountriesFromDb()
    }
}