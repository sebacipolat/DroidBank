package com.cipolat.droidbank.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cipolat.droidbank.domain.GetHomeUserUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: GetHomeUserUseCase) : ViewModel() {

    fun getUserHome(){
        viewModelScope.launch {
            val response=useCase.invoke()
        }
    }
}