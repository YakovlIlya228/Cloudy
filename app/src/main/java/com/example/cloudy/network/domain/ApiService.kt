package com.example.cloudy.network.domain

import com.example.cloudy.network.pojo.legacy.Location
import com.example.cloudy.network.pojo.legacy.LocationSearch
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/api/location/search/")
    suspend fun getLocation(@Query("query") cityName: String): LocationSearch

    @GET("/api/location/{woeid}")
    suspend fun getForecast(@Path("woeid") cityId: String): Location
}