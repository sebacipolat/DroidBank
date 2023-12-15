package com.cipolat.droidbank.data.home.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WalletItem(
    val number: String,
    val type: String,
    @Json(name ="background_color") val backgroundColor: String
)
