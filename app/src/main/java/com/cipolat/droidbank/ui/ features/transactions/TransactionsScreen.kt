package com.cipolat.droidbank.ui.transactions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.cipolat.droidbank.R
import com.cipolat.droidbank.ui.theme.poppins
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
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    text = stringResource(id = R.string.transactions_menu_header_lbl),
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = poppins
                    ),
                    textAlign = TextAlign.Start
                )
                Transactions(
                    androidx.compose.ui.Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    viewModel.state.body.value!!
                )
            }
        }
    }
}
