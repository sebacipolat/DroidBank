package com.cipolat.droidbank.data.cards.local.entities

import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import org.junit.Assert
import org.junit.Test

class LocalUserCardsTest {
    @Test
    fun `when call asEntity should return LocalUserCards object`() {
        val remoteCard = RemoteCard(
            number = "1111 1111 1111 1111",
            name = "patrick Stewart",
            expirationDate = "10/10/2035",
            cvv = "XXXX",
            type = "VISA",
            backgroundColor = ""
        )
        val entity = remoteCard.asEntity()
        Assert.assertEquals(entity.type, "VISA")
    }

    @Test
    fun `when call asCard should return Card object`() {
        val userCard = LocalUserCards(
            number = "1111 1111 1111 1111",
            name = "patrick Stewart",
            expirationDate = "10/10/2035",
            lastUpdate = "44545477",
            cvv = "XXXX",
            type = "VISA",
            backgroundColor = ""
        )
        val card = userCard.asCard()
        Assert.assertEquals(card.type, "VISA")
    }

    @Test
    fun `when call toCardList should return a Card list`() {
        val list = mutableListOf<LocalUserCards>()
        list.add(
            LocalUserCards(
                number = "1111 1111 1111 1111",
                name = "patrick Stewart",
                expirationDate = "10/10/2035",
                lastUpdate = "44545477",
                cvv = "XXXX",
                type = "VISA",
                backgroundColor = ""
            )
        )

        val cards = list.toCardList()
        Assert.assertEquals(cards.size, 1)
        Assert.assertEquals(cards[0].type, "VISA")
    }
}