package com.example.itscoronatime.countryListActivity.domain.interfaces

import com.example.itscoronatime.api.ncs.response.CountriesResponse
import io.reactivex.Single

interface CountryListinteractor {

    fun initCountryList(): Single<List<CountriesResponse>>

    fun searchCountry(name: String): Single<CountriesResponse>

}
