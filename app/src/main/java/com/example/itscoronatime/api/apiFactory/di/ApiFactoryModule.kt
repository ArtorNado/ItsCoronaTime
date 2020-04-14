package com.example.itscoronatime.api.apiFactory.di

import com.example.itscoronatime.api.apiFactory.ApiFactory
import com.example.itscoronatime.api.ncs.NovelCovidService
import com.example.itscoronatime.app.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ApiFactoryModule {

    @ApplicationScope
    @Provides
    fun provideApiFactory() = ApiFactory

    @ApplicationScope
    @Provides
    fun provideStreetChampionService(): NovelCovidService = ApiFactory.novelCovidService
}
