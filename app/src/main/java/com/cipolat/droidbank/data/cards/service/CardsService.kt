package com.cipolat.droidbank.data.cards.service

import com.cipolat.droidbank.data.cards.model.Card
import retrofit2.Response
import retrofit2.http.GET

interface CardsService {
    @GET("cards")
    suspend fun getCards(): Response<List<Card>>
}