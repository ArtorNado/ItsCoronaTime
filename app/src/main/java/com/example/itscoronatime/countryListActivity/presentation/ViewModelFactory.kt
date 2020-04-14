package com.example.itscoronatime.countryListActivity.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itscoronatime.app.navigation.Navigator
import com.example.itscoronatime.countryListActivity.di.scope.CountryListScope
import com.example.itscoronatime.countryListActivity.domain.interfaces.CountryListinteractor

@CountryListScope
class ViewModelFactory(private val countryListInteractor: CountryListinteractor,
                       private val navigator: Navigator
) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T?>): T {
        return if (modelClass == CountryListViewModel::class.java) {
            CountryListViewModel(countryListInteractor, navigator) as T
        } else {
            throw IllegalArgumentException("Invalid view model type")
        }
    }
}
