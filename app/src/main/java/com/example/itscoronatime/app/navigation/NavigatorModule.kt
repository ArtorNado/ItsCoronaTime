package com.example.itscoronatime.app.navigation

import com.example.itscoronatime.app.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class NavigatorModule {

    @ApplicationScope
    @Provides
    fun provideNavigator() = Navigator()
}
