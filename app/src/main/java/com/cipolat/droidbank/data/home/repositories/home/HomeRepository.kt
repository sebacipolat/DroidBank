package com.cipolat.droidbank.data.home.repositories.home

import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.network.Resource
import retrofit2.Response

interface HomeRepository {
    suspend fun getHomeUserData(): Response<HomeResponse>
}