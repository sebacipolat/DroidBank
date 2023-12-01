package com.cipolat.droidbank.data.cards.repositories

import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.network.Resource

interface CardsRepository {
    suspend fun getUserCards(): Resource<List<Card>>
}
