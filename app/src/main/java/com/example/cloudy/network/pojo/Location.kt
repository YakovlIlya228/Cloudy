package com.example.cloudy.network.pojo

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("consolidated_weather")
    val consolidatedWeather: ArrayList<ConsolidatedWeather>,
    @SerializedName("title")
    val title: String,
    @SerializedName("woeid")
    val woeid: Int
)