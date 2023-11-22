package com.cipolat.droidbank.ui.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cipolat.droidbank.data.cards.datasource.CardsRemoteDataSource
import com.cipolat.droidbank.data.cards.repositories.CardsRepositoryImpl
import com.cipolat.droidbank.data.cards.service.CardsService
import com.cipolat.droidbank.domain.cards.usecase.GetCardsUseCase
import com.cipolat.droidbank.network.client.HttpClient
import com.cipolat.droidbank.ui.cards.viewmodel.CardViewModel
import com.cipolat.droidbank.ui.cards.viewmodel.CardViewModelFactory

@Preview
@Composable
fun CardScreen(modifier: Modifier = Modifier) {
    val service = HttpClient.getClient().create(CardsService::class.java)
    val useCase = GetCardsUseCase(CardsRepositoryImpl(CardsRemoteDataSource(service)))
    val viewModel: CardViewModel = viewModel(factory = CardViewModelFactory(useCase))
    LaunchedEffect(Unit) {
        viewModel.getCards()
    }
    Column(Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)) {
        CardView(
            modifier = Modifier
                .padding(top = 15.dp)
        )
        CardView(
            modifier = Modifier
                .padding(top = 15.dp)
        )
        CardView(
            modifier = Modifier
                .padding(top = 15.dp)
        )
    }
}
