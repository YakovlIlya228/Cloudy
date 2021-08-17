package com.example.cloudy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cloudy.R
import com.example.cloudy.source.api.model.Location
import com.example.cloudy.source.api.model.Weather
import kotlinx.android.synthetic.main.fragment_main_weather.*


class MainWeatherFragment : Fragment() {

    private val locationAdapter by lazy { LocationAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        current_weather_pager.adapter = locationAdapter
        locationAdapter.update(
            listOf(
                Location(
                    cityName = "Moscow",
                    countryCode = "ru",
                    temp = "17.4",
                    weather = Weather(801, "Few clouds", "c02n")
                ),
                Location(
                    cityName = "Berlin",
                    countryCode = "de",
                    temp = "17.4",
                    weather = Weather(801, "Few clouds", "c02n")
                )

            )
        )
    }

    class LocationAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        private var itemList: List<Location> = listOf()

        fun getItems(): List<Location> = itemList

        fun update(newList: List<Location>) {
            itemList = newList
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int = itemList.size

        override fun createFragment(position: Int): Fragment {
            return NestedLocationWeatherFragment(itemList[position])
        }

    }
}