package com.cipolat.droidbank.domain

import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.data.home.repositories.home.HomeRepository
import com.cipolat.droidbank.network.Resource
import retrofit2.Response

class GetHomeUserUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke(): Resource<HomeResponse> {
        return repository.getHomeUserData()
    }
}