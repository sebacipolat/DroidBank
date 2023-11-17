package com.cipolat.droidbank.usecase.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.R
import com.cipolat.droidbank.usecase.theme.Gray
import com.cipolat.droidbank.usecase.theme.GrayLight
import com.cipolat.droidbank.usecase.theme.poppins

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Gray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.spotify),
                contentDescription = "avatar",
                modifier = Modifier
                    .height(35.dp)
            )
        }
        Column(
            modifier = Modifier.padding(start = 15.dp)
        ) {
            Text(
                text = "Apple Store",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppins
                ), textAlign = TextAlign.Start
            )
            Text(
                text = "Entertainment",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = GrayLight,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppins
                ), textAlign = TextAlign.Start
            )
        }
        Divider(modifier = Modifier.weight(1f), color = Color.Transparent)
        Text(
            text = "-$5.99",
            style = TextStyle(
                fontSize = 16.sp,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            ), textAlign = TextAlign.End
        )
    }
}