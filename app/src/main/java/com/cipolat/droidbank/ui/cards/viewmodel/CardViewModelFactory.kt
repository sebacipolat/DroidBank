package com.cipolat.droidbank.ui.cards.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cipolat.droidbank.domain.cards.usecase.GetCardsUseCase

class CardViewModelFactory(private val useCase: GetCardsUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CardViewModel::class.java)) {
            CardViewModel(useCase) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
