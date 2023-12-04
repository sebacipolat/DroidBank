package com.cipolat.droidbank.data.cards.model

data class Card(
    val number: String,
    val name: String,
    val expirationDate: String,
    val cvv: String,
    val type: String,
    val backgroundColor: String
)
