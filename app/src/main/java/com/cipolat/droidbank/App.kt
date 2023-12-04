package com.cipolat.droidbank

import android.app.Application
import com.cipolat.droidbank.data.database.DataStore

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DataStore.init(this)
    }
}