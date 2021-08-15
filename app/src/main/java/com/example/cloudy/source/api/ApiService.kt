package com.example.cloudy.source.api

import com.example.cloudy.BuildConfig
import com.example.cloudy.source.api.model.Forecast
import com.example.cloudy.source.api.model.Location
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        private const val key = BuildConfig.API_KEY
    }

    @GET("/forecast/daily")
    suspend fun getDailyForecast(
        @Query("city") city: String,
        @Query("country") countryCode: String,
        @Query("key") apiKey: String = key
    ): Array<Forecast>

    @GET("/current")
    suspend fun getCurrentWeather(
        @Query("city") city: String,
        @Query("country") countryCode: String,
        @Query("key") apiKey: String = key
    ): Array<Location>

}