package com.example.itscoronatime.countryListActivity.domain

import com.example.itscoronatime.api.ncs.response.CountriesResponse
import com.example.itscoronatime.countryListActivity.data.interfaces.CountryListRepository
import com.example.itscoronatime.countryListActivity.domain.interfaces.CountryListinteractor
import io.reactivex.Single
import javax.inject.Inject

class CountryListInteractorImpl @Inject constructor(
    private val countryListRepository: CountryListRepository
): CountryListinteractor {

    override fun initCountryList(): Single<List<CountriesResponse>> = countryListRepository.getCountryList()

    override fun searchCountry(name: String): Single<CountriesResponse> = countryListRepository.searchCountry(name)
}
