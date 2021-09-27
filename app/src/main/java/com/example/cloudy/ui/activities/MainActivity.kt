package com.example.cloudy.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cloudy.R
import com.example.cloudy.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(mainViewModel) {

        }

    }


}