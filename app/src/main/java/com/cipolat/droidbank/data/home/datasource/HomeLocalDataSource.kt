package com.cipolat.droidbank.data.home.datasource

import com.cipolat.droidbank.data.database.DataStore
import com.cipolat.droidbank.data.home.remote.model.HomeResponse

class HomeLocalDataSource(private val dataStore: DataStore) {
    suspend fun saveHomeData(homeResponse: HomeResponse) {
        return dataStore.saveHomeResponse(homeResponse)
    }
}
