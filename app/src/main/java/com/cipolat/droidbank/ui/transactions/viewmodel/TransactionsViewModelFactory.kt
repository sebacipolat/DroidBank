package com.cipolat.droidbank.ui.transactions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cipolat.droidbank.domain.transactions.usecase.GetTransactionsUseCase

class TransactionsViewModelFactory(private val useCase: GetTransactionsUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TransactionsViewModel::class.java)) {
            TransactionsViewModel(useCase) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
