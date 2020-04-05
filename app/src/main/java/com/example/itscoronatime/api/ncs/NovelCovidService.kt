package com.example.itscoronatime.api.ncs

import com.example.itscoronatime.api.ncs.response.CountriesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface NovelCovidService {

    @GET("countries")
    fun getCountryList():
            Single<List<CountriesResponse>>

    @GET("countries/{id}")
    fun getCountry(@Path("id") id: Int):
            Single<CountriesResponse>

    @GET("countries/{name}")
    fun searchCountry(@Path("name") name: String):
            Single<CountriesResponse>
}
