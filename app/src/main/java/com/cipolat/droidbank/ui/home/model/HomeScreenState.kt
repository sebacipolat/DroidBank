package com.cipolat.droidbank.ui.home.model

import androidx.annotation.Keep
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.cipolat.droidbank.data.home.model.HomeResponse

@Keep
data class HomeScreenState(
    var isLoading: MutableState<Boolean> = mutableStateOf(false),
    var body: MutableState<HomeResponse?> = mutableStateOf(null)
)