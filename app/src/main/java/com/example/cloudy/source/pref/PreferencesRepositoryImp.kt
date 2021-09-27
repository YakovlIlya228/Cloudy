package com.example.cloudy.source.pref

import android.content.SharedPreferences
import com.example.cloudy.source.DataConfig

class PreferencesRepositoryImp(
    private val sharedPref: SharedPreferences
) : PreferencesRepository {

    companion object {
        private const val COUNTRIES_TSP_KEY = DataConfig.COUNTRIES_TSP_KEY
    }

    override suspend fun getCountriesLastFetchTime(): Long {
        return sharedPref.getLong(COUNTRIES_TSP_KEY, -1)
    }

    override suspend fun setCountriesLastFetchTime(tsp: Long) {
        sharedPref.edit().putLong(COUNTRIES_TSP_KEY, tsp).apply()
    }
}