package com.cipolat.droidbank.ui.widgets.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.ui.theme.poppins

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    textMessage: String,
    btnMessage: String,
    image: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 20.dp, end = 20.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f), horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = modifier.weight(1.5f),
            ) {
                Text(
                    modifier = modifier.weight(1f),
                    text = textMessage,
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = MaterialTheme.colors.primaryVariant,
                        fontWeight = FontWeight.Black,
                        fontFamily = poppins
                    )
                )

            }
            Image(
                modifier = modifier.weight(1f),
                painter = painterResource(id = image),
                contentDescription = ""
            )
        }
        Spacer(modifier = modifier.weight(1.5f))
    }
}