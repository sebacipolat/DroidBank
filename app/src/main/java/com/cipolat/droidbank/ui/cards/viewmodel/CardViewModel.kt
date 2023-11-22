package com.cipolat.droidbank.ui.cards.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cipolat.droidbank.domain.cards.usecase.GetCardsUseCase
import com.cipolat.droidbank.domain.home.usecase.GetHomeUserUseCase
import com.cipolat.droidbank.network.Resource
import com.cipolat.droidbank.ui.cards.model.CardScreenState
import kotlinx.coroutines.launch

class CardViewModel(private val useCase: GetCardsUseCase) : ViewModel() {
    var state by mutableStateOf(CardScreenState())
        private set

    fun getCards() {
        viewModelScope.launch {
            val response = useCase.invoke()
            state.isLoading.value = true
            state.isError = null

            when (response.status) {
                Resource.Status.SUCCESS -> {
                    state.isLoading.value = false
                    state.body.value=response.data
                }

                Resource.Status.ERROR -> {
                    state.isLoading.value = false
                    state.isError = response.errorType
                }

                Resource.Status.LOADING -> {
                }
            }
        }
    }
}