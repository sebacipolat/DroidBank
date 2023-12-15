package com.cipolat.droidbank.ui.home.components.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.cipolat.droidbank.data.home.remote.model.WalletItem
import com.cipolat.droidbank.ui.cards.getCardIcon
import com.cipolat.droidbank.ui.theme.GrayLight
import com.cipolat.droidbank.ui.theme.poppins

@Composable
fun CardWallet(modifier: Modifier = Modifier, item: WalletItem) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val count = 3
        val total = 1f
        val first = 0.75f
        var rest = total - first
        var increase = rest / (count - 1)
        var counter = first

        for (i in 0..count - 1) {
            Card(
                modifier = Modifier
                    .offset(x = counter.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .padding(2.dp)
                    .fillMaxWidth(counter)
                    .zIndex((count - i).toFloat())
                    .height(50.dp),
                backgroundColor = Color(
                    android.graphics.Color
                        .parseColor(
                            "#" + item.backgroundColor,
                        )
                )
            ) {
                if (i == 0) {
                    fullCardBody(item)
                } else {
                    childCardBody(item)
                }
            }
            counter += increase
        }
    }
}

@Composable
fun childCardBody(item: WalletItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = item.number,
            style = TextStyle(
                textAlign = TextAlign.End,
                fontSize = 15.sp,
                color = GrayLight,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            )
        )
    }
}

@Composable
fun fullCardBody(item: WalletItem) {
    Row(
        modifier = Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentScale = ContentScale.Inside,
            painter = painterResource(id = getCardIcon(item.type)),
            contentDescription = "Card"
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp)
                .weight(2f),
            text = "**** **** **** " + item.number,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = GrayLight,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            )
        )
    }
}
