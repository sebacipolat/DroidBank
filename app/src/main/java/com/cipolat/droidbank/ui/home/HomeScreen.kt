package com.cipolat.droidbank.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cipolat.droidbank.data.home.datasource.HomeRemoteDataSource
import com.cipolat.droidbank.data.home.repositories.home.HomeRepository
import com.cipolat.droidbank.data.home.service.HomeService
import com.cipolat.droidbank.domain.GetHomeUserUseCase
import com.cipolat.droidbank.network.client.HttpClient
import com.cipolat.droidbank.ui.balance.BalanceView
import com.cipolat.droidbank.ui.home.viewmodel.HomeViewModel
import com.cipolat.droidbank.ui.home.viewmodel.HomeViewModelFactory
import com.cipolat.droidbank.ui.home.welcome.WelcomeView
import com.cipolat.droidbank.ui.transactions.Transactions
import com.cipolat.droidbank.ui.widgets.menu.Menu

@Preview
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val service = HttpClient.getClient().create(HomeService::class.java)
    val useCase = GetHomeUserUseCase(HomeRepository(HomeRemoteDataSource(service)))
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory(useCase))

    Column(Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)) {
        WelcomeView()
        BalanceView(
            modifier = Modifier
                .padding(top = 25.dp)
        )
        Menu(
            Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(), items = HomeMenu.getList()
        )
        Transactions(
            Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
        )
    }
}
