package com.cipolat.droidbank.usecase.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CardScreen(modifier: Modifier = Modifier) {
    Column(Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)) {
        CardView(
            modifier = Modifier
                .padding(top = 15.dp)
        )
        CardView(
            modifier = Modifier
                .padding(top = 15.dp)
        )
        CardView(
            modifier = Modifier
                .padding(top = 15.dp)
        )
    }
}
