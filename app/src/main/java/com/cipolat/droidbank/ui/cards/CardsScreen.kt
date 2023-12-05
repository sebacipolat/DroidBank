package com.cipolat.droidbank.ui.cards

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cipolat.droidbank.R
import com.cipolat.droidbank.data.cards.datasource.CardsLocalDataSource
import com.cipolat.droidbank.data.cards.datasource.CardsRemoteDataSource
import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.data.cards.remote.service.CardsService
import com.cipolat.droidbank.data.cards.repositories.CardsRepositoryImpl
import com.cipolat.droidbank.data.database.DataStore
import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.network.client.HttpClient
import com.cipolat.droidbank.domain.cards.usecase.GetCardsUseCase
import com.cipolat.droidbank.ui.cards.viewmodel.CardViewModel
import com.cipolat.droidbank.ui.cards.viewmodel.CardViewModelFactory
import com.cipolat.droidbank.ui.theme.poppins
import com.cipolat.droidbank.ui.widgets.error.ErrorPlaceHolder
import com.cipolat.droidbank.ui.widgets.loading.ProgressView
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Preview
@Composable
fun CardScreen(modifier: Modifier = Modifier) {
    val snackBarHostState = remember { SnackbarHostState() }
    val service = HttpClient.getClient().create(CardsService::class.java)
    val useCase = GetCardsUseCase(
        CardsRepositoryImpl(
            CardsLocalDataSource(DataStore), CardsRemoteDataSource(service)
        )
    )
    val viewModel: CardViewModel = viewModel(factory = CardViewModelFactory(useCase))
    LaunchedEffect(Unit) {
        viewModel.getCards()
    }
    Scaffold(snackbarHost = {
        SnackbarHost(hostState = snackBarHostState)
    }) {
        Column(Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)) {
            if (viewModel.state.isLoading.value) {
                ProgressView()
            } else {
                if (viewModel.state.isError != null) {
                    with(viewModel.state) {
                        errorHandler(this.isError!!, this.body, snackBarHostState) {
                            viewModel.getCards()
                        }
                    }
                } else {
                    cardBody(modifier, viewModel.state.body)
                }
            }
        }
    }
}

@Composable
fun cardBody(modifier: Modifier, body: MutableState<List<Card>?>) {
    LazyColumn(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.cards_header_lbl),
                style = TextStyle(
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppins
                ),
                textAlign = TextAlign.Start
            )
        }
        if (body.value?.isNotEmpty() == true) {
            items(body.value!!.size) {
                CardView(Modifier.fillMaxWidth(), body.value!![it])
            }
        }
    }
}

@Composable
fun errorHandler(
    errorType: Resource.ErrorType,
    body: MutableState<List<Card>?>,
    state: SnackbarHostState,
    onClick: () -> Unit
) {
    if (body.value != null) {
        showSnackBarError(state) {
            onClick()
        }
    } else {
        ErrorPlaceHolder(
            Modifier.fillMaxWidth(),
            errorType
        ) {
            onClick()
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun showSnackBarError(state: SnackbarHostState, onClick: () -> Unit) {
    val scope = rememberCoroutineScope()
    scope.launch {
        val result = state
            .showSnackbar(
                message = "Snackbar",
                actionLabel = "Action",
                duration = SnackbarDuration.Indefinite
            )
        when (result) {
            SnackbarResult.ActionPerformed -> {
                onClick()
            }

            SnackbarResult.Dismissed -> {
                /* Handle snackbar dismissed */
            }
        }
    }
}
