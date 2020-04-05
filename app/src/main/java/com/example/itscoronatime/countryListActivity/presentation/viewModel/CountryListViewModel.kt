package com.example.itscoronatime.countryListActivity.presentation.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.itscoronatime.api.ncs.response.CountriesResponse
import com.example.itscoronatime.countryListActivity.domain.CountryListInteractor
import com.example.itscoronatime.navigation.Navigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CountryListViewModel: ViewModel() {


    private val countryListInteractor = CountryListInteractor()
    private val navigator = Navigator()
    val cityList: MutableLiveData<List<CountriesResponse>> by lazy { MutableLiveData<List<CountriesResponse>>() }

    init {
        var result = countryListInteractor.initCountryList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                cityList.value = result
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
                Log.e("USTAL23222", result.toString())
                navigator.openInfo(context, result.countryInfo.id)
                Log.e("USTAL2222", result.toString())
            },
                { error -> Log.e("ERROR", error.toString()) })
    }

}

