package com.example.itscoronatime.countryListActivity.di

import com.example.itscoronatime.countryListActivity.di.scope.CountryListScope
import com.example.itscoronatime.countryListActivity.presentation.CountryListActivity
import com.example.itscoronatime.viewModelFactory.ViewModelFactoryModule
import dagger.Subcomponent

@CountryListScope
@Subcomponent(modules = [CountryListActivityModule::class, ViewModelFactoryModule::class])
interface CountryListActivityComponent {

    fun inject(countryListActivity: CountryListActivity)

    @Subcomponent.Builder
    interface Builder {

        fun build(): CountryListActivityComponent

    }


}
