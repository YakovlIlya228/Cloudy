package com.example.cloudy.network.pojo

import com.google.gson.annotations.SerializedName

data class LocationSearch(
    @SerializedName("title")
    val title: String,
    @SerializedName("woeid")
    val woeid: Int
)