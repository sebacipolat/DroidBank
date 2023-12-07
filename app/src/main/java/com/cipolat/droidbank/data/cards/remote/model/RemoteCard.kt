package com.cipolat.droidbank.data.cards.remote.model

import com.cipolat.droidbank.data.cards.model.Card
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteCard(
    val number: String,
    val name: String,
    @Json(name = "expiration_date") val expirationDate: String,
    val cvv: String,
    val type: String,
    @Json(name = "background_color") val backgroundColor: String
)

fun RemoteCard.asCard() = Card(
    number = number,
    name = name,
    expirationDate = expirationDate,
    backgroundColor = backgroundColor,
    cvv = cvv,
    type = type
)

fun List<RemoteCard>.toCardList(): List<Card> {
    val finalList = ArrayList<Card>()
    this.forEach {
        finalList.add(it.asCard())
    }
    return finalList
}
