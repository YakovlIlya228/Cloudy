package com.example.cloudy.source.api.model


import com.google.gson.annotations.SerializedName

data class LocationCount(
    @SerializedName("count")
    val count: String = "",
    @SerializedName("data")
    val `data`: List<Location> = listOf()
)