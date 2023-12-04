package com.cipolat.droidbank.ui.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.cipolat.droidbank.data.cards.remote.service.CardsService
import com.cipolat.droidbank.data.cards.repositories.CardsRepositoryImpl
import com.cipolat.droidbank.data.database.DataStore
import com.cipolat.droidbank.data.network.client.HttpClient
import com.cipolat.droidbank.domain.cards.usecase.GetCardsUseCase
import com.cipolat.droidbank.ui.cards.viewmodel.CardViewModel
import com.cipolat.droidbank.ui.cards.viewmodel.CardViewModelFactory
import com.cipolat.droidbank.ui.theme.poppins
import com.cipolat.droidbank.ui.widgets.loading.ProgressView

@Preview
@Composable
fun CardScreen(modifier: Modifier = Modifier) {
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
    Column(Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)) {
        if (viewModel.state.isLoading.value) {
            ProgressView()
        } else {
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
                if (viewModel.state.body.value?.isNotEmpty() == true) {
                    items(viewModel.state.body.value!!.size) {
                        CardView(Modifier.fillMaxWidth(), viewModel.state.body.value!![it])
                    }
                }
            }
        }
    }
}
