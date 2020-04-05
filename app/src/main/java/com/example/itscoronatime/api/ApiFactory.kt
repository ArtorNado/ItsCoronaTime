package com.example.itscoronatime.api

import com.example.itscoronatime.BuildConfig
import com.example.itscoronatime.api.ncs.NovelCovidService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val novelCovidService: NovelCovidService by lazy {
        retrofit.create(
            NovelCovidService::class.java)
    }
}
