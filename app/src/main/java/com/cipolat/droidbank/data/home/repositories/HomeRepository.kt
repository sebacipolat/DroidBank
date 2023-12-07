package com.cipolat.droidbank.data.home.repositories

import com.cipolat.droidbank.data.home.model.HomeBody
import com.cipolat.droidbank.data.network.Resource

interface HomeRepository {
    suspend fun getHomeUserData(cacheTimeLimit: Long): Resource<HomeBody>
}
