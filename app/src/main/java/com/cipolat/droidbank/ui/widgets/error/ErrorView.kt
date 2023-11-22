package com.cipolat.droidbank.ui.widgets.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.ui.theme.Blue
import com.cipolat.droidbank.ui.theme.BlueDark
import com.cipolat.droidbank.ui.theme.poppins

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    titleMessage: String,
    textMessage: String,
    btnMessage: String = "",
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
        Column(
            modifier = modifier
                .padding(
                    top = 20.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 20.dp
                )
                .clip(shape = RoundedCornerShape(15.dp))
                .background(Blue, shape = RoundedCornerShape(15.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp),
                painter = painterResource(id = image),
                contentDescription = ""
            )
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                text = titleMessage,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Black,
                    fontFamily = poppins
                )
            )
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                text = textMessage,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppins
                )
            )
            if (btnMessage.isNotBlank()) {
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 5.dp)
                        .clickable { onClick() },
                    text = btnMessage,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        color = BlueDark,
                        fontWeight = FontWeight.Normal,
                        fontFamily = poppins
                    )
                )
            }
        }
    }
}