package com.cipolat.droidbank.ui.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cipolat.droidbank.R
import com.cipolat.droidbank.data.database.DataStore
import com.cipolat.droidbank.data.home.datasource.HomeLocalDataSource
import com.cipolat.droidbank.data.home.datasource.HomeRemoteDataSource
import com.cipolat.droidbank.data.home.remote.model.HomeResponse
import com.cipolat.droidbank.data.home.remote.service.HomeService
import com.cipolat.droidbank.data.home.repositories.HomeRepositoryImpl
import com.cipolat.droidbank.data.network.client.HttpClient
import com.cipolat.droidbank.domain.home.usecase.GetHomeUserUseCase
import com.cipolat.droidbank.ui.home.balance.BalanceView
import com.cipolat.droidbank.ui.home.viewmodel.HomeViewModel
import com.cipolat.droidbank.ui.home.viewmodel.HomeViewModelFactory
import com.cipolat.droidbank.ui.home.welcome.WelcomeView
import com.cipolat.droidbank.ui.transactions.Transactions
import com.cipolat.droidbank.ui.widgets.error.ErrorPlaceHolder
import com.cipolat.droidbank.ui.widgets.loading.ProgressView
import com.cipolat.droidbank.ui.widgets.menu.Menu

@Composable
fun HomeScreen(modifier: Modifier = Modifier, context: Context) {
    val service = HttpClient.getClient().create(HomeService::class.java)
    val useCase = GetHomeUserUseCase(
        HomeRepositoryImpl(
            HomeLocalDataSource(DataStore),
            HomeRemoteDataSource(service)
        )
    )
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory(useCase))
    LaunchedEffect(Unit) {
        viewModel.getUserHome()
    }
    Column(
        modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (viewModel.state.isLoading.value) {
            ProgressView()
        } else {
            if (viewModel.state.isError != null) {
                ErrorPlaceHolder(
                    Modifier.fillMaxWidth(),
                    viewModel.state.isError!!
                ) {
                    viewModel.getUserHome()
                }
            } else {
                HomeBody(viewModel.state.body.value, context)
            }
        }
    }
}

@Composable
fun HomeBody(body: HomeResponse?, context: Context) {
    with(body) {
        this?.let { WelcomeView(it.user) }
        this?.let {
            BalanceView(
                modifier = Modifier
                    .padding(top = 25.dp),
                it.balance
            )
        }
        Menu(
            Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            items = HomeMenu.getList(),
            onClick = {
                Toast.makeText(
                    context,
                    context.getString(R.string.home_menu_not_yet),
                    Toast.LENGTH_SHORT
                ).show()
            }
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
