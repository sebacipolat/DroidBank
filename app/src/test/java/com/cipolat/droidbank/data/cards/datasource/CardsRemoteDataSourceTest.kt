package com.cipolat.droidbank.data.cards.datasource

import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.cards.remote.service.CardsService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class CardsRemoteDataSourceTest {
    private val cardsService: CardsService = mockk(relaxed = true)

    @Test
    fun `when call getCards should return card list`() =
        runBlocking {
            val fakeRemoteList = mutableListOf<RemoteCard>()
            fakeRemoteList.add(
                RemoteCard(
                    number = "1111 1111 1111 1111",
                    name = "patrick Stewart",
                    expirationDate = "10/10/2035",
                    cvv = "XXXX",
                    type = "VISA",
                    backgroundColor = ""
                )
            )
            coEvery { cardsService.getCards() } returns Response.success(fakeRemoteList)
            Assert.assertEquals(cardsService.getCards().isSuccessful, true)
            Assert.assertEquals(cardsService.getCards().body()!!.size, fakeRemoteList.size)
        }
}
