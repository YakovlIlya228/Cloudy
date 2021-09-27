package com.example.cloudy.source.db.country

import androidx.room.*


@Dao
interface CountryDao {

    @Insert
    fun insert(countryDb: CountryDb): Long

    @Update
    fun update(countryDb: CountryDb): Int

    @Delete
    fun delete(countryDb: CountryDb): Int

    @Query("DELETE FROM countries WHERE id =:countryId")
    fun deleteById(countryId: Int): Int

    @Query("SELECT * FROM countries")
    fun getCountries(): Array<CountryDb>?


}