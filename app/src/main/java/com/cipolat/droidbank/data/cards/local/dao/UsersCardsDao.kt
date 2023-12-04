package com.cipolat.droidbank.data.cards.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards

@Dao
interface UsersCardsDao {
    @Insert
    suspend fun saveCard(card: LocalUserCards)

    @Query("SELECT * FROM user_cards WHERE (:timeStamp - last_update) / 60000 <= :timeLimit")
    suspend fun getCardSince(timeLimit:String, timeStamp:String): List<LocalUserCards>

    @Query("SELECT * FROM user_cards")
    suspend fun getCards(): List<LocalUserCards>

    @Query("DELETE FROM user_cards")
    suspend fun cleanCards()
}