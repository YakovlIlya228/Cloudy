package com.example.cloudy.source.db

import com.example.cloudy.source.api.model.Country

interface DbRepository {

    suspend fun saveCountriesToDb(countries: Array<Country>)

    suspend fun getCountriesFromDb(): Array<Country>?
}