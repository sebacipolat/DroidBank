package com.cipolat.droidbank.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cipolat.droidbank.R

@Preview
@Composable
fun CardScreen(modifier: Modifier = Modifier) {
    Column(Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)) {
        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.card),
            contentDescription = "Card"
        )
        CardView(
            modifier = Modifier
                .padding(top = 15.dp)
        )
    }
}
