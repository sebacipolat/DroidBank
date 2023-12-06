package com.cipolat.droidbank.data.transactions.repositories

import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.transactions.datasource.TransactionRemoteDataSource
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem

class TransactionRepositoryImpl(private val remoteDataSource: TransactionRemoteDataSource) :
    TransactionRepository {
    override suspend fun getTransactionsData(): Resource<List<TransactionItem>> {
        return remoteDataSource.getTransactions()
    }
}