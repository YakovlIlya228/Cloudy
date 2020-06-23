package com.example.cloudy.Network.Domain

import com.example.cloudy.Network.Pojo.Location
import com.example.cloudy.Network.Pojo.LocationSearch
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AdapterRepo {
    @GET("/api/location/search/")
    suspend fun getLocation(@Query("query") cityName: String): LocationSearch

    @GET("/api/location/{woeid}")
    suspend fun getForecast(@Path("woeid") cityId: String): Location
}