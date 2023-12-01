package com.cipolat.droidbank.ui.home.welcome

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cipolat.droidbank.data.home.model.User
import com.cipolat.droidbank.ui.theme.Gray
import com.cipolat.droidbank.ui.theme.White
import com.cipolat.droidbank.ui.theme.poppins

@Composable
fun WelcomeView(
    user: User
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .clip(CircleShape)
                .border(2.dp, White, CircleShape),
            contentScale = ContentScale.Crop,
            model = user.avatarUrl,
            contentDescription = "avatar"
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
                ),
                textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = user.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppins
                ),
                textAlign = TextAlign.Start
            )
        }
    }
}
