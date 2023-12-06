package com.cipolat.droidbank.data.home.datasource

import com.cipolat.droidbank.data.home.remote.model.HomeResponse
import com.cipolat.droidbank.data.home.remote.service.HomeService
import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.network.safeApiCall

class HomeRemoteDataSource(private val homeService: HomeService) {
    suspend fun getHomeData(): Resource<HomeResponse> {
        return safeApiCall { homeService.getHome() }
    }
}
