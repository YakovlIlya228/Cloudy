package com.example.cloudy.source.api.model


import com.google.gson.annotations.SerializedName

data class ApiModel<E>(
    @SerializedName("data")
    val data: E,
)