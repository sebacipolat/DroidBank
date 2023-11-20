package com.cipolat.droidbank.data.home.datasource

import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.data.home.service.HomeService
import com.cipolat.droidbank.network.Resource
import retrofit2.Response

class HomeRemoteDataSource(private val homeService: HomeService) {
    suspend fun getHomeData(): Response<HomeResponse> {
        return homeService.getHome()
    }
}