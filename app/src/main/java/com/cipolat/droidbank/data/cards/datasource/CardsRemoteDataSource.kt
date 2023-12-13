package com.cipolat.droidbank.data.cards.datasource

import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.cards.remote.service.CardsService
import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.network.safeApiCall
import javax.inject.Inject

class CardsRemoteDataSource @Inject constructor(private val cardsService: CardsService) {
    suspend fun getCards(): Resource<List<RemoteCard>> {
        return safeApiCall { cardsService.getCards() }
    }
}
