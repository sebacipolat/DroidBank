package com.cipolat.droidbank.data.database

import android.content.Context
import androidx.room.Room
import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards
import com.cipolat.droidbank.data.cards.local.entities.asEntity
import com.cipolat.droidbank.data.cards.remote.model.RemoteCard

object DataStore {
    private const val DATABASE_NAME = "DROID_BANK_DATABASE"

    private lateinit var db: AppDatabase
    fun init(context: Context) {
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }

    suspend fun saveCards(cardList: List<RemoteCard>) {
        db.let {
            it.userCardsDao().cleanCards()
            for (card in cardList) {
                it.userCardsDao().saveCard(card.asEntity())
            }
        }
    }

    suspend fun getCardsSince(minutes: Int): List<LocalUserCards> {
        db.let {
            return it.userCardsDao().getCardSince(minutes.toString(),System.currentTimeMillis().toString())
        }
    }

    suspend fun getAllCards(): List<LocalUserCards> {
        db.let {
            return it.userCardsDao().getCards()
        }
    }
}