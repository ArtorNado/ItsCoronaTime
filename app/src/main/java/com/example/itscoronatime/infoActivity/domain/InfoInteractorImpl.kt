package com.example.itscoronatime.infoActivity.domain

import com.example.itscoronatime.infoActivity.data.interfaces.InfoRepository
import com.example.itscoronatime.infoActivity.domain.interfaces.InfoInteractor
import javax.inject.Inject

class InfoInteractorImpl @Inject constructor(
    private val infoRepository: InfoRepository
): InfoInteractor {

    override fun getCountry(id: Int) = infoRepository.getCountry(id)
}
