package com.cipolat.droidbank

import android.app.Application
import com.cipolat.droidbank.data.database.DataStore
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
