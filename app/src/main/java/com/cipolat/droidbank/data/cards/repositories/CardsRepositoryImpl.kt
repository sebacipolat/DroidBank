package com.cipolat.droidbank.data.cards.repositories

import com.cipolat.droidbank.data.cards.datasource.CardsLocalDataSource
import com.cipolat.droidbank.data.cards.datasource.CardsRemoteDataSource
import com.cipolat.droidbank.data.cards.local.entities.toCardList
import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.data.cards.remote.model.toCardList
import com.cipolat.droidbank.data.network.Resource
import javax.inject.Inject

class CardsRepositoryImpl @Inject constructor(
    private val localDataSource: CardsLocalDataSource,
    private val remoteDataSource: CardsRemoteDataSource
) : CardsRepository {

    override suspend fun getUserCards(cacheTimeLimit: Int): Resource<List<Card>> {
        val storedSinceCards = localDataSource.getCardsSince(cacheTimeLimit)
        if (storedSinceCards.isEmpty()) {
            val response = remoteDataSource.getCards()
            val data = response.data
            when (response.status) {
                Resource.Status.SUCCESS -> {
                    localDataSource.saveCards(data!!)
                    return Resource.success(data.toCardList())
                }

                Resource.Status.ERROR -> {
                    val allCards = localDataSource.getCards()
                    return if (allCards.isEmpty()) {
                        Resource.error(
                            errorType = response.errorType,
                            data = allCards.toCardList()
                        )
                    } else {
                        Resource.error(response.errorType)
                    }
                }

                else -> {
                    return Resource.error(response.errorType)
                }
            }
        } else {
            return Resource.success(storedSinceCards.toCardList())
        }
    }
}
