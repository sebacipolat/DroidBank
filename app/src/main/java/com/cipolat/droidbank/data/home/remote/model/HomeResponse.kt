package com.cipolat.droidbank.data.home.remote.model

import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeResponse(
    val user: User,
    val balance: Balance,
    val transactions: List<TransactionItem>
)
