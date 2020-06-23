package com.example.cloudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudy.Adapters.cityListAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var weather = ArrayList<weather>()
        weather.add(0, weather("Moscow","s","+15"))
        weather.add(1, weather("New York","c", "+22"))
        weather.add(2, weather("Paris","hc","+19"))
        weather.add(3, weather("Warsaw","lr", "+13"))
        val recyclerView: RecyclerView = findViewById(R.id.cityList)
        val cityListAdapter = cityListAdapter(weather)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = cityListAdapter
    }

}