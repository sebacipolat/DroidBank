package com.cipolat.droidbank.domain.cards.usecase

import com.cipolat.droidbank.data.cards.repositories.CardsRepository
import com.cipolat.droidbank.data.network.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetCardsUseCaseTest {
    @Test
    fun `when invoke GetCardsUseCase should return a Resource`() = runBlocking {
        val repository: CardsRepository = mockk(relaxed = true)
        val useCase = GetCardsUseCase(repository)
        coEvery { useCase.invoke() } returns Resource.success(emptyList())
        Assert.assertEquals(useCase.invoke().status, Resource.Status.SUCCESS)
    }
}