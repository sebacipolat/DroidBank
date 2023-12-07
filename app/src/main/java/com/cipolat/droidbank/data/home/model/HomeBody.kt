package com.cipolat.droidbank.data.home.model

import com.cipolat.droidbank.data.home.remote.model.Balance
import com.cipolat.droidbank.data.home.remote.model.User
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem

data class HomeBody(
    val user: User,
    val balance: Balance,
    val transactions: List<TransactionItem>
)
