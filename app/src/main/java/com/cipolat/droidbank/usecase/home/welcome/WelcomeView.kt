package com.cipolat.droidbank.usecase.home.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.R
import com.cipolat.droidbank.usecase.theme.Gray
import com.cipolat.droidbank.usecase.theme.White
import com.cipolat.droidbank.usecase.theme.poppins

@Preview
@Composable
fun WelcomeView(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.people),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .height(50.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(2.dp, White, CircleShape)   // add a border (optional)
        )
        Column(
            Modifier.padding(start = 12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Welcome back,",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Gray,
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppins
                ), textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Tanya Myroniuk",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppins
                ), textAlign = TextAlign.Start
            )
        }
    }
}