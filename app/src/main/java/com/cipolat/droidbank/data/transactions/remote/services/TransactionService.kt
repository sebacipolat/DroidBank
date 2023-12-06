package com.cipolat.droidbank.data.transactions.remote.services

import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem
import retrofit2.Response
import retrofit2.http.GET

interface TransactionService {
    @GET("movements")
    suspend fun getMovements(): Response<List<TransactionItem>>
}
