package com.cipolat.droidbank.data.home.datasource

import com.cipolat.droidbank.data.database.DataStore
import com.cipolat.droidbank.data.home.local.entity.HomeResponseEntity
import com.cipolat.droidbank.data.home.remote.model.HomeResponse
import javax.inject.Inject

class HomeLocalDataSource @Inject constructor(private val dataStore: DataStore) {
    suspend fun saveHomeData(homeResponse: HomeResponse) {
        return dataStore.saveHomeResponse(homeResponse)
    }

    suspend fun getHomeData(): HomeResponseEntity {
        return dataStore.getHome()
    }
}
