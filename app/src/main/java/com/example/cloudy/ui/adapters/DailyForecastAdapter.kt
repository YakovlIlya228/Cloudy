package com.example.cloudy.ui.adapters

import android.view.View
import com.example.cloudy.R
import com.example.cloudy.source.api.model.Forecast
import com.example.cloudy.utils.Extensions.parseIcon
import kotlinx.android.synthetic.main.daily_forecast_item.view.*

class DailyForecastAdapter : AbstractAdapter<Forecast>(R.layout.daily_forecast_item) {

    override fun onBind(itemView: View, item: Forecast, position: Int) {
        with(itemView) {
            val timestamp = item.ts.toString()
//            weekdayTv.text = timestamp.getWeekday()
//            forecastDate.text = timestamp.getDateFromTimestamp()
            forecastDescription.text = item.weather.description
            forecastTemp.text = item.temp.toString()
            item.weather.code.parseIcon()?.let { weatherIcon.setImageResource(it) }
        }
    }
}