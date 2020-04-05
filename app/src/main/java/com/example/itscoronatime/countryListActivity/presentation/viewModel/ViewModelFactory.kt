package com.example.itscoronatime.countryListActivity.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T?>): T {
        return if (modelClass == CountryListViewModel::class.java) {
            CountryListViewModel() as T
        } else {
            throw IllegalArgumentException("Invalid view model type")
        }
    }
}
