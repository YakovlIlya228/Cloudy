package com.example.cloudy.network.pojo.legacy

import com.google.gson.annotations.SerializedName

data class ConsolidatedWeather(
    @SerializedName("id")
    val id: Int,
    @SerializedName("weather_state_name")
    val weatherState: String,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String,
    @SerializedName("min_temp")
    val minTemp: Double,
    @SerializedName("max_temp")
    val maxTemp: Double,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_direction")
    val windDirection: String,
    @SerializedName("air_pressure")
    val airPressure: Double,
    @SerializedName("humidity")
    val humidity: Int
)