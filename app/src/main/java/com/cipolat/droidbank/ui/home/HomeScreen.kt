package com.cipolat.droidbank.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cipolat.droidbank.ui.balance.BalanceView
import com.cipolat.droidbank.ui.home.welcome.WelcomeView
import com.cipolat.droidbank.ui.transactions.Transactions
import com.cipolat.droidbank.ui.widgets.menu.Menu

@Preview
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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
