package com.cipolat.droidbank.ui.home.model

import androidx.annotation.Keep
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.cipolat.droidbank.data.home.model.HomeBody
import com.cipolat.droidbank.data.network.Resource

@Keep
data class HomeScreenState(
    var isLoading: MutableState<Boolean> = mutableStateOf(true),
    var body: MutableState<HomeBody?> = mutableStateOf(null),
    var isError: Resource.ErrorType? = null
)
