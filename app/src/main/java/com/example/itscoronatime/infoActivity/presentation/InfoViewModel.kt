package com.example.itscoronatime.infoActivity.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.itscoronatime.infoActivity.domain.interfaces.InfoInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InfoViewModel(
    private val infoInteractor: InfoInteractor,
    private val id: Int
) : ViewModel() {


    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _critical = MutableLiveData<String>()
    val critical: LiveData<String> = _critical

    private val _deaths = MutableLiveData<String>()
    val deaths: LiveData<String> = _deaths

    private val _recovered = MutableLiveData<String>()
    val recovered: LiveData<String> = _recovered

    private val _todayCases = MutableLiveData<String>()
    val todayCases: LiveData<String> = _todayCases

    private val _todayDeaths = MutableLiveData<String>()
    val todayDeaths: LiveData<String> = _todayDeaths

    init{
        var result = infoInteractor.getCountry(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                _name.value = result.country
                _critical.value = result.critical.toString()
                _deaths.value = result.deaths.toString()
                _recovered.value = result.recovered.toString()
                _todayCases.value = result.todayCases.toString()
                _todayDeaths.value = result.todayDeaths.toString()
            },
                { error -> Log.e("ERROR", error.toString()) })

    }
}
