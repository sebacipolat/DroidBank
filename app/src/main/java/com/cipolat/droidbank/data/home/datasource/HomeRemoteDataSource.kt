package com.cipolat.droidbank.data.home.datasource

import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.data.home.service.HomeService

class HomeRemoteDataSource(private val homeService: HomeService) {
    suspend fun getHomeData(): Result<HomeResponse> {
        return homeService.getHome()
    }
}