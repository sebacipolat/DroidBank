package com.cipolat.droidbank.data.home.repositories.home

import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.network.Resource

interface HomeRepository {
    suspend fun getHomeUserData(): Resource<HomeResponse>
}