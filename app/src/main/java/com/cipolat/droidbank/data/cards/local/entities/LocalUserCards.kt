package com.cipolat.droidbank.data.cards.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.utils.DateUtils

@Entity(tableName = "user_cards")
data class LocalUserCards(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val number: String,
    val name: String,
    @ColumnInfo(name = "expiration_date") val expirationDate: String,
    @ColumnInfo(name = "last_update") val lastUpdate: String,
    val cvv: String,
    val type: String,
    @ColumnInfo(name = "background_color") val backgroundColor: String
)

fun RemoteCard.asEntity() = LocalUserCards(
    number = number,
    name = name,
    expirationDate = expirationDate,
    backgroundColor = backgroundColor,
    cvv = cvv,
    type = type,
    lastUpdate = System.currentTimeMillis().toString()
)

fun LocalUserCards.asCard() = Card(
    number = number,
    name = name,
    expirationDate = expirationDate,
    backgroundColor = backgroundColor,
    cvv = cvv,
    type = type
)

fun List<LocalUserCards>.toCardList(): List<Card> {
    val finalList = ArrayList<Card>()
    this.forEach {
        finalList.add(it.asCard())
    }
    return finalList
}


