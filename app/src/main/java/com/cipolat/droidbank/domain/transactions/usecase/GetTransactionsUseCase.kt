package com.cipolat.droidbank.domain.transactions.usecase

import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem
import com.cipolat.droidbank.data.transactions.repositories.TransactionRepository
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(private val repository: TransactionRepository) {
    suspend operator fun invoke(): Resource<List<TransactionItem>> {
        return repository.getTransactionsData()
    }
}
