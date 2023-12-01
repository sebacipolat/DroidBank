package com.cipolat.droidbank.ui.widgets.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.ui.theme.poppins

@Composable
fun CircleButton(
    iconIDLight: Int,
    iconIDDark: Int,
    text: String,
    contentDescription: String = "",
    onClick: () -> (Unit)
) {
    val imageResource = if (isSystemInDarkTheme()) {
        iconIDDark
    } else {
        iconIDLight
    }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primaryVariant),
            shape = CircleShape,
            modifier = Modifier.size(54.dp)
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(50.dp)
                    .clip(CircleShape),
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
