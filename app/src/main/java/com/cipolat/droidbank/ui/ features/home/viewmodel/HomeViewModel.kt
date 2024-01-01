package com.cipolat.droidbank.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.domain.home.usecase.GetHomeUserUseCase
import com.cipolat.droidbank.ui.home.model.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: GetHomeUserUseCase) : ViewModel() {
    var state by mutableStateOf(HomeScreenState())
        private set

    fun getUserHome() {
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
                }

                Resource.Status.LOADING -> {
                }
            }
        }
    }
}
