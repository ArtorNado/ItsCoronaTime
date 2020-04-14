package com.example.itscoronatime.app

import android.app.Application
import com.example.itscoronatime.app.injector.Injector

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }

}
