package com.example.cloudy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudy.R
import com.example.cloudy.source.api.model.Location
import com.example.cloudy.ui.adapters.DailyForecastAdapter
import com.example.cloudy.ui.adapters.diff_utils.ForecastDiffUtilCallback
import com.example.cloudy.ui.utils.Extensions.gone
import com.example.cloudy.ui.viewmodels.LocationWeatherViewModel
import com.example.cloudy.utils.Extensions.parseIcon
import kotlinx.android.synthetic.main.current_weather_main_info.*
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

    override fun onResume() {
        super.onResume()
        shimmerLayout.startShimmer()
    }

    override fun onPause() {
        super.onPause()
        shimmerLayout.stopShimmer()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(dailyWeatherRv) {
            layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = dailyForecastAdapter
        }
        with(locationWeatherViewModel) {
            dailyWeatherForecast.observe(viewLifecycleOwner) {
                val diffUtilCallback =
                    ForecastDiffUtilCallback(dailyForecastAdapter.getItems(), it.toList())
                dailyForecastAdapter.submitList(it.toList(), diffUtilCallback)
            }
            currentLocationWeather.observe(viewLifecycleOwner) {
                it.bindLocation()
            }
            fetchDailyForecast(location.cityName, location.countryCode) {
                Toast.makeText(
                    requireContext(),
                    resources.getString(R.string.error),
                    Toast.LENGTH_SHORT
                ).show()
            }
            fetchCurrentWeather(location.cityName, location.countryCode)
        }

    }

    private fun Location.bindLocation() {
        currentLocation.text = cityName
        currentTemp.text = temp
        weatherDescription.text = weather.description
        weather.code.parseIcon()?.let { weatherIcon.setImageResource(it) }
        shimmerLayout.hideShimmer()
        shimmerLayout.gone()
    }

}