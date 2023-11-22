package com.cipolat.droidbank.data.cards.repositories

import com.cipolat.droidbank.data.cards.datasource.CardsRemoteDataSource
import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.network.Resource

class CardsRepositoryImpl(private val remoteDataSource: CardsRemoteDataSource) : CardsRepository {

    override suspend fun getUserCards(): Resource<ArrayList<Card>> {
        val response = remoteDataSource.getCards()
        return when (response.status) {
            Resource.Status.SUCCESS -> {
                response
            }

            Resource.Status.ERROR -> {
                response
            }

            else -> {
                response
            }
        }
    }
}
