package com.example.itscoronatime.countryListActivity.data

import com.example.itscoronatime.api.ApiFactory
import com.example.itscoronatime.api.ncs.response.CountriesResponse
import io.reactivex.Single

class CountryListRepository {

    private val service = ApiFactory.novelCovidService

    fun getCountryList(): Single<List<CountriesResponse>> = service.getCountryList()

    fun searchCountry(name: String): Single<CountriesResponse> = service.searchCountry(name)

}
