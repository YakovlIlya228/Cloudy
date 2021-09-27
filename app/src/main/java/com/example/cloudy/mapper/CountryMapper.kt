package com.example.cloudy.mapper

import com.example.cloudy.source.api.model.Country
import com.example.cloudy.source.db.country.CountryDb


fun Country.toDb() = CountryDb(
    name = this.name,
    iso2 = this.iso2,
    iso3 = this.iso3
)

fun CountryDb.toUi() = Country(
    name, iso2, iso3
)

fun Array<Country>.toDb(): Array<CountryDb> = map { it.toDb() }.toTypedArray()

fun Array<CountryDb>.toUi(): Array<Country> = map { it.toUi() }.toTypedArray()

