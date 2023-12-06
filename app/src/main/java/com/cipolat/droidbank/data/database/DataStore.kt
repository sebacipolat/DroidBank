package com.cipolat.droidbank.data.database

import android.content.Context
import androidx.room.Room
import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards
import com.cipolat.droidbank.data.cards.local.entities.asEntity
import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.home.local.entity.BalanceEntity
import com.cipolat.droidbank.data.home.local.entity.UserEntity
import com.cipolat.droidbank.data.home.local.entity.asEntityList
import com.cipolat.droidbank.data.home.remote.model.HomeResponse

object DataStore {
    private const val DATABASE_NAME = "DROID_BANK_DATABASE"

    private lateinit var db: AppDataBase
    fun init(context: Context) {
        db = Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            DATABASE_NAME
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

    suspend fun saveHomeResponse(homeResponse: HomeResponse) {
        db.let {
            it.userDataDao().insertUser(
                UserEntity(
                    name = homeResponse.user.name,
                    avatarUrl = homeResponse.user.avatarUrl
                )
            )
            it.userDataDao().insertBalance(BalanceEntity(mount = homeResponse.balance.mount))
            it.userDataDao().insertTransactions(homeResponse.transactions.asEntityList())
        }
    }

    suspend fun getCardsSince(minutes: Int): List<LocalUserCards> {
        db.let {
            return it.userCardsDao()
                .getCardSince(minutes.toString(), System.currentTimeMillis().toString())
        }
    }

    suspend fun getAllCards(): List<LocalUserCards> {
        db.let {
            return it.userCardsDao().getCards()
        }
    }
}
