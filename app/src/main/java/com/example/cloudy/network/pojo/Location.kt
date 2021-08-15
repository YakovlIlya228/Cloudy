package com.example.cloudy.network.pojo


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("app_temp")
    val appTemp: Int = 0,
    @SerializedName("aqi")
    val aqi: Int = 0,
    @SerializedName("city_name")
    val cityName: String = "",
    @SerializedName("clouds")
    val clouds: Int = 0,
    @SerializedName("country_code")
    val countryCode: String = "",
    @SerializedName("datetime")
    val datetime: String = "",
    @SerializedName("dewpt")
    val dewpt: Int = 0,
    @SerializedName("dhi")
    val dhi: Int = 0,
    @SerializedName("dni")
    val dni: Int = 0,
    @SerializedName("elev_angle")
    val elevAngle: Double = 0.0,
    @SerializedName("ghi")
    val ghi: Int = 0,
    @SerializedName("h_angle")
    val hAngle: Int = 0,
    @SerializedName("lat")
    val lat: Double = 0.0,
    @SerializedName("lon")
    val lon: Double = 0.0,
    @SerializedName("ob_time")
    val obTime: String = "",
    @SerializedName("pod")
    val pod: String = "",
    @SerializedName("precip")
    val precip: Int = 0,
    @SerializedName("pres")
    val pres: Double = 0.0,
    @SerializedName("rh")
    val rh: Int = 0,
    @SerializedName("slp")
    val slp: Int = 0,
    @SerializedName("snow")
    val snow: Int = 0,
    @SerializedName("solar_rad")
    val solarRad: Int = 0,
    @SerializedName("state_code")
    val stateCode: String = "",
    @SerializedName("station")
    val station: String = "",
    @SerializedName("sunrise")
    val sunrise: String = "",
    @SerializedName("sunset")
    val sunset: String = "",
    @SerializedName("temp")
    val temp: String = "",
    @SerializedName("timezone")
    val timezone: String = "",
    @SerializedName("ts")
    val ts: Int = 0,
    @SerializedName("uv")
    val uv: Int = 0,
    @SerializedName("vis")
    val vis: Int = 0,
    @SerializedName("weather")
    val weather: Weather,
    @SerializedName("wind_cdir")
    val windCdir: String = "",
    @SerializedName("wind_cdir_full")
    val windCdirFull: String = "",
    @SerializedName("wind_dir")
    val windDir: Int = 0,
    @SerializedName("wind_spd")
    val windSpd: Int = 0
)