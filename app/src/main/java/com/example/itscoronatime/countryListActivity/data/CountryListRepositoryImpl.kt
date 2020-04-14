package com.example.itscoronatime.countryListActivity.data

import com.example.itscoronatime.api.ncs.NovelCovidService
import com.example.itscoronatime.api.ncs.response.CountriesResponse
import com.example.itscoronatime.countryListActivity.data.interfaces.CountryListRepository
import io.reactivex.Single
import javax.inject.Inject

class CountryListRepositoryImpl @Inject constructor(
    private val service: NovelCovidService ): CountryListRepository {

    override fun getCountryList(): Single<List<CountriesResponse>> = service.getCountryList()

    override fun searchCountry(name: String): Single<CountriesResponse> = service.searchCountry(name)

}
