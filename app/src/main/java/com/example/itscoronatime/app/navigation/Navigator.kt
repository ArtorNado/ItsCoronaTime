package com.example.itscoronatime.app.navigation

import android.content.Context
import com.example.itscoronatime.infoActivity.presentation.InfoActivity
import com.example.itscoronatime.infoActivity.router.InfoRouter

class Navigator: InfoRouter {

    override fun openInfo(context: Context, id: Int) {
        InfoActivity.start(context, id)
    }

}
