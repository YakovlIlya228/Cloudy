package com.example.cloudy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.example.cloudy.R
import com.example.cloudy.network.pojo.Location
import kotlinx.android.synthetic.main.fragment_location_weather_nested.*

class NestedLocationWeatherFragment(private val location: Location) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_location_weather_nested, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        location.bindLocation()
    }

    private fun Location.bindLocation() {
        currentLocation.text = cityName
        currentTemp.text = temp
        weatherDescription.text = weather.description
        weather.code.parseIcon()?.let { weatherIcon.setImageResource(it) }
    }

    @DrawableRes
    fun Int.parseIcon(): Int? = when (this) {
        801, 802 -> R.drawable.ic_lc
        621, 622, 623 -> R.drawable.ic_sn
        511, 522, 520 -> R.drawable.ic_hr
        500, 501 -> R.drawable.ic_lr
        230, 231, 232, 233 -> R.drawable.ic_t
        800 -> R.drawable.ic_c
        803, 804 -> R.drawable.ic_hc
        611, 612 -> R.drawable.ic_sl
        else -> null
    }
}