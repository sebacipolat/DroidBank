package com.cipolat.droidbank.data.database

import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards
import com.cipolat.droidbank.data.cards.local.entities.asEntity
import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.home.local.entity.BalanceEntity
import com.cipolat.droidbank.data.home.local.entity.HomeResponseEntity
import com.cipolat.droidbank.data.home.local.entity.UserEntity
import com.cipolat.droidbank.data.home.local.entity.asEntityList
import com.cipolat.droidbank.data.home.remote.model.HomeResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStore @Inject constructor(private var db: AppDataBase) {

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
            it.userDataDao().cleanUserData()
            it.userDataDao().insertUser(
                UserEntity(
                    name = homeResponse.user.name,
                    avatarUrl = homeResponse.user.avatarUrl
                )
            )
            it.userDataDao().insertBalance(
                BalanceEntity(
                    mount = homeResponse.balance.mount,
                    lastUpdate = System.currentTimeMillis().toString()
                )
            )
            it.userDataDao().insertTransactions(homeResponse.transactions.asEntityList())
        }
    }

    suspend fun getHome(): HomeResponseEntity {
        db.let {
            val response = it.userDataDao().getHomeResponse()
            val transaction = it.userDataDao().getTransactions()
            if(transaction.isNotEmpty()){
                response.transactions=transaction.subList(0,4)
            }
            return response
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
