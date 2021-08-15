package com.example.cloudy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudy.R
import com.example.cloudy.source.api.model.Location
import com.example.cloudy.ui.adapters.DailyForecastAdapter
import com.example.cloudy.ui.viewmodels.LocationWeatherViewModel
import com.example.cloudy.utils.Extensions.parseIcon
import kotlinx.android.synthetic.main.fragment_location_weather_nested.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NestedLocationWeatherFragment(private val location: Location) : Fragment() {

    private val locationWeatherViewModel: LocationWeatherViewModel by viewModel()
    private val dailyForecastAdapter by lazy { DailyForecastAdapter() }

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
        with(dailyWeatherRv) {
            layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = dailyForecastAdapter
        }
        with(locationWeatherViewModel) {
            dailyWeatherForecast.observe(viewLifecycleOwner) {
                dailyForecastAdapter.update(it.toList())
            }

            fetchDailyForecast("moscow", "ru")
        }

    }

    private fun Location.bindLocation() {
        currentLocation.text = cityName
        currentTemp.text = temp
        weatherDescription.text = weather.description
        weather.code.parseIcon()?.let { weatherIcon.setImageResource(it) }
    }

}