package com.cipolat.droidbank.ui.cards.model

import androidx.annotation.Keep
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.network.Resource

@Keep
data class CardScreenState(
    var isLoading: MutableState<Boolean> = mutableStateOf(true),
    var body: MutableState<HomeResponse?> = mutableStateOf(null),
    var isError: Resource.ErrorType? = null
)