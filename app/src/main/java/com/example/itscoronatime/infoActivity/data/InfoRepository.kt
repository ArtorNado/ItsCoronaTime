package com.example.itscoronatime.infoActivity.data

import com.example.itscoronatime.api.ApiFactory

class InfoRepository {

    private val service = ApiFactory.novelCovidService

    fun getCountry(id: Int) = service.getCountry(id)
}
