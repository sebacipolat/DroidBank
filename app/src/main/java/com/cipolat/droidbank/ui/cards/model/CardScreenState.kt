package com.cipolat.droidbank.ui.cards.model

import androidx.annotation.Keep
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.data.cards.remote.model.RemoteCard
import com.cipolat.droidbank.data.network.Resource

@Keep
data class CardScreenState(
    var isLoading: MutableState<Boolean> = mutableStateOf(true),
    var body: MutableState<List<Card>?> = mutableStateOf(null),
    var isError: Resource.ErrorType? = null
)
