package com.cipolat.droidbank.ui.transactions.model

import androidx.annotation.Keep
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem

@Keep
data class TransactionsScreenState(
    var isLoading: MutableState<Boolean> = mutableStateOf(true),
    var body: MutableState<List<TransactionItem>?> = mutableStateOf(null),
    var isError: Resource.ErrorType? = null
)
