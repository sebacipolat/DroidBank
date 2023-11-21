package com.cipolat.droidbank.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cipolat.droidbank.data.home.datasource.HomeRemoteDataSource
import com.cipolat.droidbank.data.home.model.HomeResponse
import com.cipolat.droidbank.data.home.repositories.HomeRepositoryImpl
import com.cipolat.droidbank.data.home.service.HomeService
import com.cipolat.droidbank.domain.GetHomeUserUseCase
import com.cipolat.droidbank.network.client.HttpClient
import com.cipolat.droidbank.ui.balance.BalanceView
import com.cipolat.droidbank.ui.home.viewmodel.HomeViewModel
import com.cipolat.droidbank.ui.home.viewmodel.HomeViewModelFactory
import com.cipolat.droidbank.ui.home.welcome.WelcomeView
import com.cipolat.droidbank.ui.transactions.Transactions
import com.cipolat.droidbank.ui.widgets.loading.ProgressView
import com.cipolat.droidbank.ui.widgets.menu.Menu

@Preview
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val service = HttpClient.getClient().create(HomeService::class.java)
    val useCase = GetHomeUserUseCase(HomeRepositoryImpl(HomeRemoteDataSource(service)))
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory(useCase))
    LaunchedEffect(Unit) {
        viewModel.getUserHome()
    }
    Column(
        Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (viewModel.state.isLoading.value) {
            ProgressView()
        } else {
            if (viewModel.state.isError != null) {

            } else {
                HomeBody(viewModel.state.body.value)
            }
        }
    }
}

@Composable
fun HomeBody(body: HomeResponse?) {
    with(body) {
        this?.let { WelcomeView(it.user) }
        this?.let {
            BalanceView(
                modifier = androidx.compose.ui.Modifier
                    .padding(top = 25.dp),
                it.balance
            )
        }
        Menu(
            androidx.compose.ui.Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(), items = com.cipolat.droidbank.ui.home.HomeMenu.getList()
        )
        this?.let {
            Transactions(
                androidx.compose.ui.Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                it.transactions
            )
        }
    }
}