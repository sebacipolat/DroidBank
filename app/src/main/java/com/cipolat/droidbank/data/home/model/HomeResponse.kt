package com.cipolat.droidbank.data.home.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeResponse(
    val user: User,
    val balance: Balance,
    val transactions: List<TransactionItem>
)
