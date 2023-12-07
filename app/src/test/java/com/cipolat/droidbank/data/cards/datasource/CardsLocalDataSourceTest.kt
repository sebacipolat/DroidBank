package com.cipolat.droidbank.data.cards.datasource

import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards
import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.database.DataStore
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class CardsLocalDataSourceTest {
    private val dataStoreMock: DataStore = mockk(relaxed = true)

    @Test
    fun `when call saveCards should return the saved card when getCards and retrieve list`() =
        runBlocking {
            val localDataSource = CardsLocalDataSource(dataStoreMock)
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
            val fakeList = mutableListOf<LocalUserCards>()
            fakeList.add(
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
            coEvery { dataStoreMock.saveCards(fakeRemoteList) } returns Unit
            coEvery { dataStoreMock.getAllCards() } returns fakeList
            localDataSource.saveCards(fakeRemoteList)
            Assert.assertEquals(localDataSource.getCards().size, fakeList.size)
        }

    @Test
    fun `when call getCards should return a card list`() = runBlocking {
        val localDataSource = CardsLocalDataSource(dataStoreMock)
        val fakeList = ArrayList<LocalUserCards>()
        fakeList.add(
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
        coEvery { dataStoreMock.getAllCards() } returns fakeList
        Assert.assertEquals(localDataSource.getCards().size, fakeList.size)
    }

    @Test
    fun `when call getCardsSince should return a card list`() = runBlocking {
        val localDataSource = CardsLocalDataSource(dataStoreMock)
        val fakeList = ArrayList<LocalUserCards>()
        fakeList.add(
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
        coEvery { dataStoreMock.getCardsSince(100) } returns fakeList
        Assert.assertEquals(localDataSource.getCardsSince(100).size, fakeList.size)
    }
}