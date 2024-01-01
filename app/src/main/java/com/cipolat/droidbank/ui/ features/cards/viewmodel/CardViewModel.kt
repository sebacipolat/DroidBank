package com.cipolat.droidbank.ui.cards.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.domain.cards.usecase.GetCardsUseCase
import com.cipolat.droidbank.ui.cards.model.CardScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CardViewModel @Inject constructor(private val useCase: GetCardsUseCase) : ViewModel() {
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
                    state.body.value = response.data
                }

                Resource.Status.ERROR -> {
                    state.isLoading.value = false
                    state.isError = response.errorType
                    if (!state.body.value.isNullOrEmpty()) {
                        state.body.value = response.data
                    }
                }

                Resource.Status.LOADING -> {
                }
            }
        }
    }
}
