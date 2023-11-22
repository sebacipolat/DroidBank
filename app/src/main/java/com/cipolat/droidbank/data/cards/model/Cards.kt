package com.cipolat.droidbank.data.cards.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Card(
    val number: String,
    val name: String,
    @Json(name = "expiration_date") val expirationDate: String,
    val cvv: String,
    val type: String,
    @Json(name = "background_color") val backgroundColor: String,
)