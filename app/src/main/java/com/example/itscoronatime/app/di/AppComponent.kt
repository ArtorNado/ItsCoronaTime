package com.example.itscoronatime.app.di

import com.example.itscoronatime.api.apiFactory.di.ApiFactoryModule
import com.example.itscoronatime.app.App
import com.example.itscoronatime.app.navigation.NavigatorModule
import com.example.itscoronatime.app.scope.ApplicationScope
import com.example.itscoronatime.countryListActivity.di.CountryListActivityComponent
import com.example.itscoronatime.infoActivity.di.InfoActivityComponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [NavigatorModule::class, ApiFactoryModule::class])
interface AppComponent {

    fun countryListActivityComponent(): CountryListActivityComponent.Builder

    fun infoActivityComponent(): InfoActivityComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
