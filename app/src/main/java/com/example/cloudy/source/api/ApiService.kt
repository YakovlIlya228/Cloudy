package com.example.cloudy.source.api

import com.example.cloudy.BuildConfig
import com.example.cloudy.source.api.model.ApiModel
import com.example.cloudy.source.api.model.Forecast
import com.example.cloudy.source.api.model.LocationCount
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        private const val key = BuildConfig.API_KEY
        private const val V2 = "v2.0"
    }

    @GET("$V2/forecast/daily")
    suspend fun getDailyForecast(
        @Query("city") city: String,
        @Query("country") countryCode: String,
        @Query("key") apiKey: String = key
    ): ApiModel<Array<Forecast>>

    @GET("$V2/current")
    suspend fun getCurrentWeather(
        @Query("city") city: String,
        @Query("country") countryCode: String,
        @Query("key") apiKey: String = key
    ): LocationCount

}