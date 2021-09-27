package com.example.cloudy.source.api.model


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val name: String,
    @SerializedName("Iso2")
    val iso2: String,
    @SerializedName("Iso3")
    val iso3: String
)