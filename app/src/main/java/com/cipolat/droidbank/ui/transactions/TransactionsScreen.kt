package com.cipolat.droidbank.ui.transactions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cipolat.droidbank.ui.transactions.viewmodel.TransactionsViewModel
import com.cipolat.droidbank.ui.widgets.error.ErrorPlaceHolder
import com.cipolat.droidbank.ui.widgets.loading.ProgressView

@Preview
@Composable
fun TransactionsScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<TransactionsViewModel>()
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
