package com.cipolat.droidbank.data.cards.datasource

import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.data.cards.service.CardsService
import com.cipolat.droidbank.network.Resource
import com.cipolat.droidbank.network.safeApiCall

class CardsRemoteDataSource(private val cardsService: CardsService) {
    suspend fun getCards(): Resource<List<Card>> {
        return safeApiCall { cardsService.getCards() }
    }
}
