package com.example.itscoronatime.infoActivity.domain.interfaces

import com.example.itscoronatime.api.ncs.response.CountriesResponse
import io.reactivex.Single

interface InfoInteractor {

    fun getCountry(id: Int): Single<CountriesResponse>
}
