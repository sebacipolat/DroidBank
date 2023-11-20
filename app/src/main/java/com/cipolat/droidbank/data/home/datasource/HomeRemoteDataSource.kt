package com.cipolat.droidbank.data.home.datasource

import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.data.home.service.HomeService
import com.cipolat.droidbank.network.Resource
import com.cipolat.droidbank.network.safeApiCall

class HomeRemoteDataSource(private val homeService: HomeService) {
    suspend fun getHomeData(): Resource<HomeResponse> {
        return safeApiCall { homeService.getHome() }
    }
}