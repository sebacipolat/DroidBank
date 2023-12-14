package com.cipolat.droidbank.ui.transactions.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.domain.transactions.usecase.GetTransactionsUseCase
import com.cipolat.droidbank.ui.transactions.model.TransactionsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(private val useCase: GetTransactionsUseCase) :
    ViewModel() {
    var state by mutableStateOf(TransactionsScreenState())
        private set

    fun getUserTransactions() {
        viewModelScope.launch {
            val response = useCase.invoke()
            state.isLoading.value = true
            state.isError = null

            when (response.status) {
                Resource.Status.SUCCESS -> {
                    state.isLoading.value = false
                    state.body.value = response.data!!
                }

                Resource.Status.ERROR -> {
                    state.isLoading.value = false
                    state.isError = response.errorType
                }

                else -> {}
            }
        }
    }
}
