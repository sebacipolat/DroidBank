package com.cipolat.droidbank.ui.widgets.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.ui.theme.White
import com.cipolat.droidbank.ui.theme.poppins

@Composable
fun CircleButton(
    iconIDLight: Int,
    iconIDDark: Int,
    text: String,
    contentDescription: String = "",
    onClick: () -> (Unit)
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primaryVariant),
            shape = CircleShape,
            modifier = Modifier.size(54.dp),
        ) {
            Image(
                painter = painterResource(iconIDLight),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(50.dp)
                    .clip(CircleShape)
                    .border(2.dp, White, CircleShape),
                alignment = Alignment.Center
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            text = text,
            style = TextStyle(
                fontSize = 15.sp,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Medium,
                fontFamily = poppins
            )
        )
    }
}