package com.example.cloudy.Adapters

import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudy.Network.Pojo.Location
import com.example.cloudy.R
import com.example.cloudy.weather

class cityListAdapter(private val weatherList: List<weather>): RecyclerView.Adapter<cityListAdapter.cityListViewHolder>() {
    class cityListViewHolder(inflater: LayoutInflater, parent: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.location_item, parent, false)){
            var cityTextView: TextView? = null
            var weatherIcon: ImageView? = null
            var temperatureTextView: TextView? = null
            init {
                cityTextView = itemView.findViewById(R.id.cityName)
                weatherIcon = itemView.findViewById(R.id.weatherIcon)
                temperatureTextView = itemView.findViewById(R.id.temperature)
            }

        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cityListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return cityListViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: cityListViewHolder, position: Int) {
//        holder.cityTextView?.text = location.title
        holder.cityTextView?.text = weatherList[position].location
//        holder.temperatureTextView?.text = ((location.consolidatedWeather[0].maxTemp + location.consolidatedWeather[0].minTemp)/2).toString()
        holder.temperatureTextView?.text = weatherList[position].temperature
//        location.consolidatedWeather[0].weatherStateAbbr
        when(weatherList[position].stateAbbr){
            "s" -> holder.weatherIcon?.setImageResource(R.drawable.ic_s)
            "c" ->  holder.weatherIcon?.setImageResource(R.drawable.ic_c)
            "h" ->  holder.weatherIcon?.setImageResource(R.drawable.ic_h)
            "hc" ->  holder.weatherIcon?.setImageResource(R.drawable.ic_hc)
            "hr" ->  holder.weatherIcon?.setImageResource(R.drawable.ic_hr)
            "lc" ->  holder.weatherIcon?.setImageResource(R.drawable.ic_lc)
            "lr" ->  holder.weatherIcon?.setImageResource(R.drawable.ic_lr)
            "sn" ->  holder.weatherIcon?.setImageResource(R.drawable.ic_sn)
            "sl" ->  holder.weatherIcon?.setImageResource(R.drawable.ic_sl)
            "t" ->  holder.weatherIcon?.setImageResource(R.drawable.ic_t)
        }
    }
}