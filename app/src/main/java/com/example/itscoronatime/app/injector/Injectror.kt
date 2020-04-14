package com.example.itscoronatime.app.injector

import com.example.itscoronatime.app.App
import com.example.itscoronatime.app.di.AppComponent
import com.example.itscoronatime.app.di.DaggerAppComponent
import com.example.itscoronatime.countryListActivity.di.CountryListActivityComponent
import com.example.itscoronatime.infoActivity.di.InfoActivityComponent

object Injector {

    lateinit var appComponent: AppComponent
    private var countryListActivityComponent: CountryListActivityComponent? = null
    private var infoActivityComponent: InfoActivityComponent? = null

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusCountryListActivityComponent(): CountryListActivityComponent = countryListActivityComponent
        ?: appComponent.countryListActivityComponent()
        .build().also {
            countryListActivityComponent = it
        }

    fun clearCountryListActivityComponent() {
        countryListActivityComponent = null
    }

    fun plusInfoComponent(id: Int): InfoActivityComponent = infoActivityComponent
        ?: appComponent.infoActivityComponent()
        .create(id).also {
            infoActivityComponent = it
        }

    fun clearInfoActivityComponent() {
        infoActivityComponent = null
    }

}
