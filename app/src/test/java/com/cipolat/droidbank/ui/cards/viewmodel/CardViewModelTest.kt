package com.cipolat.droidbank.ui.cards.viewmodel

import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.domain.cards.usecase.GetCardsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class CardViewModelTest {

    @Test
    fun `when invoke GetCardsUseCase should return a Resource`() = runTest {
        val useCase: GetCardsUseCase = mockk(relaxed = true)
        val cardViewModel = CardViewModel(useCase)
        coEvery { useCase.invoke() } returns Resource.error()
        cardViewModel.getCards()
        Assert.assertEquals(cardViewModel.state.isError, Resource.Status.ERROR)
    }
}