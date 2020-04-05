package com.example.itscoronatime.countryListActivity.domain

import com.example.itscoronatime.api.ncs.response.CountriesResponse
import com.example.itscoronatime.countryListActivity.data.CountryListRepository
import io.reactivex.Single

class CountryListInteractor {

    val countryListRepository = CountryListRepository()

    fun initCountryList(): Single<List<CountriesResponse>> = countryListRepository.getCountryList()

    fun searchCountry(name: String): Single<CountriesResponse> = countryListRepository.searchCountry(name)
}
