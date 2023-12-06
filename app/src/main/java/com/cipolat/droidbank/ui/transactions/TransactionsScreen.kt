package com.cipolat.droidbank.ui.transactions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cipolat.droidbank.data.network.client.HttpClient
import com.cipolat.droidbank.data.transactions.datasource.TransactionRemoteDataSource
import com.cipolat.droidbank.data.transactions.remote.services.TransactionService
import com.cipolat.droidbank.data.transactions.repositories.TransactionRepositoryImpl
import com.cipolat.droidbank.domain.transactions.usecase.GetTransactionsUseCase
import com.cipolat.droidbank.ui.transactions.viewmodel.TransactionsViewModel
import com.cipolat.droidbank.ui.transactions.viewmodel.TransactionsViewModelFactory
import com.cipolat.droidbank.ui.widgets.error.ErrorPlaceHolder
import com.cipolat.droidbank.ui.widgets.loading.ProgressView

@Preview
@Composable
fun TransactionsScreen(modifier: Modifier = Modifier) {
    val service = HttpClient.getClient().create(TransactionService::class.java)
    val useCase =
        GetTransactionsUseCase(TransactionRepositoryImpl(TransactionRemoteDataSource(service)))
    val viewModel: TransactionsViewModel =
        viewModel(factory = TransactionsViewModelFactory(useCase))
    LaunchedEffect(Unit) {
        viewModel.getUserTransactions()
    }
    Column(Modifier.padding(start = 20.dp, top = 5.dp, end = 20.dp)) {
        if (viewModel.state.isLoading.value) {
            ProgressView()
        } else {
            if (viewModel.state.isError != null) {
                ErrorPlaceHolder(
                    Modifier.fillMaxWidth(),
                    viewModel.state.isError!!
                ) {
                    viewModel.getUserTransactions()
                }
            } else {
                Transactions(
                    androidx.compose.ui.Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    viewModel.state.body.value!!
                )
            }
        }
    }
}
