package com.example.itscoronatime.infoActivity.di

import com.example.itscoronatime.infoActivity.di.scope.InfoScope
import com.example.itscoronatime.infoActivity.presentation.InfoActivity
import com.example.itscoronatime.viewModelFactory.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Subcomponent

@InfoScope
@Subcomponent(modules = [InfoActivityModule::class, ViewModelFactoryModule::class])
interface InfoActivityComponent {

    fun injectInfoActivityComponent(infoActivity: InfoActivity)

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance id: Int
        ): InfoActivityComponent
    }
}
