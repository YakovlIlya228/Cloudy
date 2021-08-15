package com.example.cloudy.source.api.model.legacy

import com.google.gson.annotations.SerializedName

data class LocationSearch(
    @SerializedName("title")
    val title: String,
    @SerializedName("woeid")
    val woeid: Int
)