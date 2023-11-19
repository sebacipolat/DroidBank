package com.cipolat.droidbank.data.home.model

import com.squareup.moshi.Json

data class TransactionItem(
    val type: String,
    val value: String,
    @Json(name = "icon_url") val iconUrl: String
)