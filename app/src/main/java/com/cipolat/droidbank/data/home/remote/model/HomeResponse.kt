package com.cipolat.droidbank.data.home.remote.model

import com.cipolat.droidbank.data.home.model.HomeBody
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeResponse(
    val user: User,
    val balance: Balance,
    val transactions: List<TransactionItem>
)

fun HomeResponse.asHomeBody(): HomeBody {
    return HomeBody(this.user, this.balance, this.transactions)
}
