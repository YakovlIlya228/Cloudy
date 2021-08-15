package com.example.cloudy.source.api.model


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("icon")
    val icon: String = ""
)