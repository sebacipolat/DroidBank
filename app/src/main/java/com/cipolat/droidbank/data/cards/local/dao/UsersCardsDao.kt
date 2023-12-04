package com.cipolat.droidbank.data.cards.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards

@Dao
interface UsersCardsDao {
    @Insert
    suspend fun saveCard(card: LocalUserCards)

    @Query("SELECT * FROM user_cards WHERE (strftime('%s', 'now') - strftime('%s', last_update)) / 60 <= :minutes")
    suspend fun getCardSince(minutes: Int): List<LocalUserCards>

    @Query("SELECT * FROM user_cards")
    suspend fun getCards(): List<LocalUserCards>

    @Query("DELETE FROM user_cards")
    suspend fun cleanCards()
}