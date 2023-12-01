package com.cipolat.droidbank.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cipolat.droidbank.domain.home.usecase.GetHomeUserUseCase

class HomeViewModelFactory(private val useCase: GetHomeUserUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(useCase) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
