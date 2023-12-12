package com.cipolat.droidbank.domain.home.usecase

import com.cipolat.droidbank.data.home.model.HomeBody
import com.cipolat.droidbank.data.home.repositories.HomeRepository
import com.cipolat.droidbank.data.network.Resource
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GetHomeUserUseCase @Inject constructor(private val repository: HomeRepository) {
    suspend operator fun invoke(): Resource<HomeBody> {
        return repository.getHomeUserData(TimeUnit.MINUTES.toMillis(5))
    }
}
