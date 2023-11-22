package com.cipolat.droidbank.data.home.repositories

import com.cipolat.droidbank.data.home.datasource.HomeRemoteDataSource
import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.network.Resource

class HomeRepositoryImpl(private val remoteDataSource: HomeRemoteDataSource) : HomeRepository {

    override suspend fun getHomeUserData(): Resource<HomeResponse> {
        val response = remoteDataSource.getHomeData()
        return when (response.status) {
            Resource.Status.SUCCESS -> {
                response
            }

            Resource.Status.ERROR -> {
                response
            }

            else -> {
                response
            }
        }
    }
}
