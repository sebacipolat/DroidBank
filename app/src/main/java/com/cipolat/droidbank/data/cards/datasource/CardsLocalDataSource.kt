package com.cipolat.droidbank.data.cards.datasource

import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards
import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.database.DataStore

class CardsLocalDataSource(private val dataStore: DataStore) {
    suspend fun saveCards(cardList: List<RemoteCard>) {
        return dataStore.saveCards(cardList)
    }

    suspend fun getCardsSince(timeLimit: Int): List<LocalUserCards> {
        return dataStore.getCardsSince(timeLimit)
    }

    suspend fun getCards(): List<LocalUserCards> {
        return dataStore.getAllCards()
    }
}
