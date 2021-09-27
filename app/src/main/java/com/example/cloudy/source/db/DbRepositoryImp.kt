package com.example.cloudy.source.db

import com.example.cloudy.mapper.toDb
import com.example.cloudy.mapper.toUi
import com.example.cloudy.source.api.model.Country
import com.example.cloudy.source.db.country.CountryDao

class DbRepositoryImp(
    private val countryDao: CountryDao
) : DbRepository {

    override suspend fun saveCountriesToDb(countries: Array<Country>) {
        countries.forEach {
            countryDao.insert(it.toDb())
        }
    }

    override suspend fun getCountriesFromDb(): Array<Country>? {
        return countryDao.getCountries()?.toUi()
    }
}