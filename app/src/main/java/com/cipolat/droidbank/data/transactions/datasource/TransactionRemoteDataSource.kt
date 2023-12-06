package com.cipolat.droidbank.data.transactions.datasource

import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.network.safeApiCall
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem
import com.cipolat.droidbank.data.transactions.remote.services.TransactionService

class TransactionRemoteDataSource(private val remoteService: TransactionService) {
    suspend fun getTransactions(): Resource<List<TransactionItem>> {
        return safeApiCall { remoteService.getMovements() }
    }
}
