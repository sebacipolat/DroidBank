package com.cipolat.droidbank.data.cards.remote.service

import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import retrofit2.Response
import retrofit2.http.GET

interface CardsService {
    @GET("cards")
    suspend fun getCards(): Response<List<RemoteCard>>
}
