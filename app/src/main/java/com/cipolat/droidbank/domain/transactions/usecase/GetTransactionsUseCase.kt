package com.cipolat.droidbank.domain.transactions.usecase

import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem
import com.cipolat.droidbank.data.transactions.repositories.TransactionRepository

class GetTransactionsUseCase(private val repository: TransactionRepository) {
    suspend operator fun invoke(): Resource<List<TransactionItem>> {
        return repository.getTransactionsData()
    }
}
