package com.cipolat.droidbank.data.home.repositories

import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.data.network.Resource

interface HomeRepository {
    suspend fun getHomeUserData(): Resource<HomeResponse>
}
