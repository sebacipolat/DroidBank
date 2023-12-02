package com.cipolat.droidbank.domain.home.usecase

import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.data.home.repositories.HomeRepository
import com.cipolat.droidbank.network.Resource

class GetHomeUserUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke(): Resource<HomeResponse> {
        return repository.getHomeUserData()
    }
}