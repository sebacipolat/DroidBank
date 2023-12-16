package com.cipolat.droidbank.ui.home.components.balance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.R
import com.cipolat.droidbank.data.home.remote.model.Balance
import com.cipolat.droidbank.ui.theme.Blue
import com.cipolat.droidbank.ui.theme.GrayLight
import com.cipolat.droidbank.ui.theme.White
import com.cipolat.droidbank.ui.theme.poppins

@Composable
fun BalanceView(modifier: Modifier = Modifier, balance: Balance) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(15.dp))
            .background(MaterialTheme.colors.onBackground, shape = RoundedCornerShape(15.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            text = stringResource(id = R.string.home_balance),
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = GrayLight,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            )
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 2.dp, bottom = 25.dp
                ),
            text = balance.mount,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                color = White,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            )
        )
    }
}
