package com.cipolat.droidbank.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import com.cipolat.droidbank.domain.GetHomeUserUseCase

class HomeViewModel(val useCase: GetHomeUserUseCase) : ViewModel() {
}