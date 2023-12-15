package com.cipolat.droidbank.data.cards.repositories

import com.cipolat.droidbank.data.cards.datasource.CardsLocalDataSource
import com.cipolat.droidbank.data.cards.datasource.CardsRemoteDataSource
import com.cipolat.droidbank.data.cards.local.entities.LocalUserCards
import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.network.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class CardsRepositoryImplTest {

    @Test
    fun `when call getUserCards and there empty cache should get from remote`() = runBlocking {
        val localDataSource: CardsLocalDataSource = mockk(relaxed = true)
        val remoteDataSource: CardsRemoteDataSource = mockk(relaxed = true)
        val time = 15
        var repositoryImpl = CardsRepositoryImpl(localDataSource, remoteDataSource)
        coEvery { localDataSource.getCardsSince(time) } returns emptyList()
        val remoteList = mutableListOf<RemoteCard>()
        remoteList.add(
            RemoteCard(
                number = "1111 1111 1111 1111",
                name = "patrick Stewart",
                expirationDate = "10/10/2035",
                cvv = "XXXX",
                type = "VISA",
                backgroundColor = ""
            )
        )
        coEvery { remoteDataSource.getCards() } returns Resource.success(remoteList)
        val response = repositoryImpl.getUserCards(time)
        Assert.assertEquals(response.status, Resource.Status.SUCCESS)
        Assert.assertEquals(response.data!![0].type, "VISA")
    }

    @Test
    fun `when call getUserCards and there stored cache should get from local instead remote`() =
        runBlocking {
            val localDataSource: CardsLocalDataSource = mockk(relaxed = true)
            val remoteDataSource: CardsRemoteDataSource = mockk(relaxed = true)
            val time = 15
            val cacheUser = "from cache"
            var repositoryImpl = CardsRepositoryImpl(localDataSource, remoteDataSource)
            val localList = mutableListOf<LocalUserCards>()
            localList.add(
                LocalUserCards(
                    number = "1111 1111 1111 1111",
                    name = cacheUser,
                    expirationDate = "10/10/2035",
                    lastUpdate = "44545477",
                    cvv = "XXXX",
                    type = "VISA",
                    backgroundColor = ""
                )
            )
            coEvery { localDataSource.getCardsSince(time) } returns localList
            val response = repositoryImpl.getUserCards(time)
            Assert.assertEquals(response.status, Resource.Status.SUCCESS)
            Assert.assertEquals(response.data!![0].name, cacheUser)
        }

    @Test
    fun `when call getUserCards and get and fail remote request should status error`() =
        runBlocking {
            val localDataSource: CardsLocalDataSource = mockk(relaxed = true)
            val remoteDataSource: CardsRemoteDataSource = mockk(relaxed = true)
            val time = 15
            var repositoryImpl = CardsRepositoryImpl(localDataSource, remoteDataSource)
            coEvery { localDataSource.getCardsSince(time) } returns emptyList()
            coEvery { remoteDataSource.getCards() } returns Resource.error()
            val response = repositoryImpl.getUserCards(time)
            Assert.assertEquals(response.status, Resource.Status.ERROR)
        }
}