package com.example.itscoronatime.infoActivity.domain

import com.example.itscoronatime.infoActivity.data.InfoRepository

class InfoInteractor {

    private val infoRepository = InfoRepository()

    fun getCountry(id: Int) = infoRepository.getCountry(id)
}
