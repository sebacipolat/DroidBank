package com.cipolat.droidbank.data.transactions.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransactionItem(
    val name: String,
    val type: String,
    val value: String,
    @Json(name = "icon_url") val iconUrl: String
)
