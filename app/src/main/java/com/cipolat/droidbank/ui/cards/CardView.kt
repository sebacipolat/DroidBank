package com.cipolat.droidbank.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.R
import com.cipolat.droidbank.ui.theme.Blue
import com.cipolat.droidbank.ui.theme.White
import com.cipolat.droidbank.ui.theme.poppins

@Preview
@Composable
fun CardView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(199.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Blue, shape = RoundedCornerShape(15.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 15.dp),
        ) {
            Image(
                contentScale = ContentScale.Fit,
                painter = painterResource(id = R.drawable.chip_1),
                contentDescription = "chip"
            )
            Divider(
                modifier = Modifier
                    .weight(1.5f), color = Color.Transparent
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
            text = "4562 1122 4595 7852",
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
            text = "Sebastian Cipolat",
            style = TextStyle(
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                color = White,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 15.dp),
        ) {
            
        }
    }
}