package com.cipolat.droidbank.data.cards.datasource

import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.cards.remote.service.CardsService
import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.network.safeApiCall

class CardsRemoteDataSource(private val cardsService: CardsService) {
    suspend fun getCards(): Resource<List<RemoteCard>> {
        return safeApiCall { cardsService.getCards() }
    }
}
