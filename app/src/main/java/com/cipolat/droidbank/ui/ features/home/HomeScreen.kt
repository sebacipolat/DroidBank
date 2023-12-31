package com.cipolat.droidbank.ui.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cipolat.droidbank.R
import com.cipolat.droidbank.data.home.model.HomeBody
import com.cipolat.droidbank.ui.home.components.balance.BalanceView
import com.cipolat.droidbank.ui.home.components.menu.HomeMenu
import com.cipolat.droidbank.ui.home.components.welcome.WelcomeView
import com.cipolat.droidbank.ui.home.viewmodel.HomeViewModel
import com.cipolat.droidbank.ui.theme.poppins
import com.cipolat.droidbank.ui.transactions.Transactions
import com.cipolat.droidbank.ui.widgets.error.ErrorPlaceHolder
import com.cipolat.droidbank.ui.widgets.loading.ProgressView
import com.cipolat.droidbank.ui.widgets.menu.Menu

@Composable
fun HomeScreen(modifier: Modifier = Modifier, context: Context) {
    val viewModel = hiltViewModel<HomeViewModel>()
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
                HomeContent(viewModel.state.body.value, context)
            }
        }
    }
}

@Composable
fun HomeContent(body: HomeBody?, context: Context) {
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
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                text = stringResource(id = R.string.home_transactions_lbl),
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
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                it.transactions
            )
        }
    }
}
