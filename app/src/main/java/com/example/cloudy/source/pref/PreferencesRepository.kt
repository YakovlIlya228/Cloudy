package com.example.cloudy.source.pref

interface PreferencesRepository {

    suspend fun getCountriesLastFetchTime(): Long

    suspend fun setCountriesLastFetchTime(tsp: Long)

}