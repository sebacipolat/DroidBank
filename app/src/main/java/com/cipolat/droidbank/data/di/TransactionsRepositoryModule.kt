package com.cipolat.droidbank.data.di

import com.cipolat.droidbank.data.transactions.repositories.TransactionRepository
import com.cipolat.droidbank.data.transactions.repositories.TransactionRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TransactionsRepositoryModule {
    @Binds
    abstract fun bindTransactionRepository(
        transactionRepository: TransactionRepositoryImpl
    ): TransactionRepository
}