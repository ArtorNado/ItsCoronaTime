package com.example.itscoronatime.countryListActivity.data.interfaces

import com.example.itscoronatime.api.ncs.response.CountriesResponse
import io.reactivex.Single

interface CountryListRepository {

    fun getCountryList(): Single<List<CountriesResponse>>

    fun searchCountry(name: String): Single<CountriesResponse>

}
