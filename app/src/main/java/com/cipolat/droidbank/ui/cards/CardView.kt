package com.cipolat.droidbank.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.cipolat.droidbank.R
import com.cipolat.droidbank.data.cards.model.Card
import com.cipolat.droidbank.ui.theme.GrayLight
import com.cipolat.droidbank.ui.theme.White
import com.cipolat.droidbank.ui.theme.poppins

object CardBrand {
    const val VISA = "VISA"
    const val MASTER_CARD = "MASTERCARD"
}

@Composable
fun CardView(modifier: Modifier = Modifier, card: Card) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(199.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(
                color = Color(android.graphics.Color.parseColor("#" + card.backgroundColor)),
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 15.dp)
        ) {
            Image(
                contentScale = ContentScale.Fit,
                painter = painterResource(id = R.drawable.chip_1),
                contentDescription = "chip"
            )
            Divider(
                modifier = Modifier
                    .weight(1.5f),
                color = Color.Transparent
            )
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.nfc),
                contentDescription = "Card"
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 15.dp),
            text = card.number,
            style = TextStyle(
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                color = White,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            )
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 15.dp),
            text = card.name,
            style = TextStyle(
                textAlign = TextAlign.Start,
                fontSize = 13.sp,
                color = White,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 8.dp, end = 15.dp)
        ) {
            Column() {
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    text = "Expiry Date",
                    style = TextStyle(
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp,
                        color = GrayLight,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppins
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp),
                    text = card.expirationDate,
                    style = TextStyle(
                        textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        color = White,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppins
                    )
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 15.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    text = "CVV",
                    style = TextStyle(
                        textAlign = TextAlign.Start,
                        fontSize = 10.sp,
                        color = GrayLight,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppins
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp),
                    text = card.cvv,
                    style = TextStyle(
                        textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        color = White,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppins
                    )
                )
            }
            Divider(
                modifier = Modifier
                    .weight(1.5f),
                color = Color.Transparent
            )
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = getCardIcon(card.type)),
                contentDescription = "Card"
            )
        }
    }
}

fun getCardIcon(type: String): Int {
    return when (type.toUpperCase()) {
        CardBrand.VISA -> {
            R.drawable.visa_icon
        }

        CardBrand.MASTER_CARD -> {
            R.drawable.mastercard_icon
        }

        else -> {
            R.drawable.chip_1
        }
    }
}
