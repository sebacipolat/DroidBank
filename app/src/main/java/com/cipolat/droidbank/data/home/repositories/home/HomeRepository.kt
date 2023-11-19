package com.cipolat.droidbank.data.home.repositories.home

import com.cipolat.droidbank.data.home.datasource.HomeRemoteDataSource
import com.cipolat.droidbank.data.home.model.HomeResponse

class HomeRepository(private val remoteDataSource: HomeRemoteDataSource) {

    suspend fun getHomeUserData(): Result<HomeResponse> {
        return remoteDataSource.getHomeData()
    }
}