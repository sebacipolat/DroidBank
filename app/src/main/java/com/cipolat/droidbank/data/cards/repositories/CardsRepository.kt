package com.cipolat.droidbank.data.cards.repositories

import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.data.network.Resource

interface CardsRepository {
    suspend fun getUserCards(cacheTimeLimit: Int): Resource<List<Card>>
}
