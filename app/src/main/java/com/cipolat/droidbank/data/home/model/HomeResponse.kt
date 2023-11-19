package com.cipolat.droidbank.data.home.model

data class HomeResponse(
    val user: User,
    val balance: Balance,
    val transactions: ArrayList<TransactionItem>
)