package com.cipolat.droidbank.data.home.repositories.home

import com.cipolat.droidbank.data.home.datasource.HomeRemoteDataSource
import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.network.Resource
import retrofit2.Response

class HomeRepositoryImpl(private val remoteDataSource: HomeRemoteDataSource) : HomeRepository {

    override suspend fun getHomeUserData(): Response<HomeResponse> {
        return remoteDataSource.getHomeData()
    }
}
