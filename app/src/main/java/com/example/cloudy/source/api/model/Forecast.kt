package com.example.cloudy.source.api.model


import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("moonrise_ts")
    val moonriseTs: Int,
    @SerializedName("wind_cdir")
    val windCdir: String,
    @SerializedName("rh")
    val rh: Int,
    @SerializedName("pres")
    val pres: Double,
    @SerializedName("high_temp")
    val highTemp: Double,
    @SerializedName("sunset_ts")
    val sunsetTs: Int,
    @SerializedName("ozone")
    val ozone: Double,
    @SerializedName("moon_phase")
    val moonPhase: Double,
    @SerializedName("wind_gust_spd")
    val windGustSpd: Double,
    @SerializedName("snow_depth")
    val snowDepth: Double,
    @SerializedName("clouds")
    val clouds: Int,
    @SerializedName("ts")
    val ts: Long,
    @SerializedName("sunrise_ts")
    val sunriseTs: Int,
    @SerializedName("app_min_temp")
    val appMinTemp: Double,
    @SerializedName("wind_spd")
    val windSpd: Double,
    @SerializedName("pop")
    val pop: Int,
    @SerializedName("wind_cdir_full")
    val windCdirFull: String,
    @SerializedName("slp")
    val slp: Double,
    @SerializedName("moon_phase_lunation")
    val moonPhaseLunation: Double,
    @SerializedName("valid_date")
    val validDate: String,
    @SerializedName("app_max_temp")
    val appMaxTemp: Double,
    @SerializedName("vis")
    val vis: Double,
    @SerializedName("dewpt")
    val dewpt: Double,
    @SerializedName("snow")
    val snow: Double,
    @SerializedName("uv")
    val uv: Double,
    @SerializedName("weather")
    val weather: Weather,
    @SerializedName("wind_dir")
    val windDir: Int,
    @SerializedName("max_dhi")
    val maxDhi: Any,
    @SerializedName("clouds_hi")
    val cloudsHi: Int,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("low_temp")
    val lowTemp: Double,
    @SerializedName("max_temp")
    val maxTemp: Double,
    @SerializedName("moonset_ts")
    val moonsetTs: Int,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("min_temp")
    val minTemp: Double,
    @SerializedName("clouds_mid")
    val cloudsMid: Int,
    @SerializedName("clouds_low")
    val cloudsLow: Int
)