package com.cipolat.droidbank.data.transactions.repositories

import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem

interface TransactionRepository {
    suspend fun getTransactionsData(): Resource<List<TransactionItem>>
}
