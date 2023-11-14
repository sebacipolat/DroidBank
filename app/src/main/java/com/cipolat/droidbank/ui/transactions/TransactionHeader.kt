package com.cipolat.droidbank.ui.transactions

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.ui.theme.Blue
import com.cipolat.droidbank.ui.theme.poppins

@Composable
fun TransactionHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
    ) {
        Text(
            text = "Transaction", style = TextStyle(
                fontSize = 18.sp,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            ), textAlign = TextAlign.Start
        )
        Divider(
            modifier = Modifier.weight(1f), color = Color.Transparent
        )
        Text(
            text = "See All", style = TextStyle(
                fontSize = 14.sp, color = Blue, fontWeight = FontWeight.Medium, fontFamily = poppins
            ), textAlign = TextAlign.Start
        )
    }
}