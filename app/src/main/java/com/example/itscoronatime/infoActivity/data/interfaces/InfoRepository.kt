package com.example.itscoronatime.infoActivity.data.interfaces

import com.example.itscoronatime.api.ncs.response.CountriesResponse
import io.reactivex.Single

interface InfoRepository {

    fun getCountry(id: Int): Single<CountriesResponse>

}
