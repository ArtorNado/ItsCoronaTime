package com.example.itscoronatime.infoActivity.data

import com.example.itscoronatime.api.ncs.NovelCovidService
import com.example.itscoronatime.infoActivity.data.interfaces.InfoRepository
import javax.inject.Inject

class InfoRepositoryImpl @Inject constructor(
    private val service: NovelCovidService
): InfoRepository {

    override fun getCountry(id: Int) = service.getCountry(id)

}
