package com.example.cloudy.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cloudy.domain.usecase.GetAllCountriesUseCase
import com.example.cloudy.source.api.model.Country

class MainViewModel(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {

    val countries by lazy { MutableLiveData<Array<Country>>() }


    override fun onCleared() {
        super.onCleared()
        getAllCountriesUseCase.unsubscribe()
    }


    fun fetchAllCountries() {
        getAllCountriesUseCase.execute {
            onError { println(it) }
            onComplete {
                countries.postValue(it)
            }
        }
    }
}