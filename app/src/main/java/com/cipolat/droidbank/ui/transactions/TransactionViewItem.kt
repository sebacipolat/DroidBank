package com.cipolat.droidbank.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem
import com.cipolat.droidbank.ui.theme.Gray
import com.cipolat.droidbank.ui.theme.GrayLight
import com.cipolat.droidbank.ui.theme.poppins

@Composable
fun TransactionViewItem(
    modifier: Modifier = Modifier,
    item: TransactionItem
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
            AsyncImage(
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
                    .padding(5.dp),
                contentScale = ContentScale.Crop,
                model = item.iconUrl,
                contentDescription = "avatar"
            )
        }
        Column(
            modifier = Modifier.padding(start = 15.dp)
        ) {
            Text(
                text = item.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppins
                ),
                textAlign = TextAlign.Start
            )
            Text(
                text = item.type,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = GrayLight,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppins
                ),
                textAlign = TextAlign.Start
            )
        }
        Divider(modifier = Modifier.weight(1f), color = Color.Transparent)
        Text(
            text = item.value,
            style = TextStyle(
                fontSize = 16.sp,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            ),
            textAlign = TextAlign.End
        )
    }
}
