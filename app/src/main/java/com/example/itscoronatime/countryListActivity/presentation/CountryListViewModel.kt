package com.example.itscoronatime.countryListActivity.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.itscoronatime.api.ncs.response.CountriesResponse
import com.example.itscoronatime.app.navigation.Navigator
import com.example.itscoronatime.countryListActivity.domain.interfaces.CountryListinteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CountryListViewModel(
    private val countryListInteractor: CountryListinteractor,
    private val navigator: Navigator
): ViewModel() {

    private val _cityList = MutableLiveData<List<CountriesResponse>>()
    val cityList: LiveData<List<CountriesResponse>> = _cityList

    init {
        var result = countryListInteractor.initCountryList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                _cityList.value = result
            },
                { error -> Log.e("ERROR", error.toString()) })

    }

    fun clickOnView(context: Context, id: Int) {
        navigator.openInfo(context, id)
    }

    fun search(context: Context, name: String) {
        val result = countryListInteractor.searchCountry(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                navigator.openInfo(context, result.countryInfo.id)
            },
                { error -> Log.e("ERROR", error.toString()) })
    }

}

