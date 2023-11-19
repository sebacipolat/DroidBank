package com.cipolat.droidbank.domain

import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.data.home.repositories.home.HomeRepository

class GetHomeUserUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke(): Result<HomeResponse> {
        return repository.getHomeUserData()
    }
}