package com.cipolat.droidbank.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = White,
    primaryVariant = BlackGray,
    secondary = Teal200,
    background = Black,
    onBackground = Blue,
    onPrimary = White,
    onSurface = BlackGray
)

private val LightColorPalette = lightColors(
    primary = Gray,
    primaryVariant = WhiteGray,
    secondary = Teal200,
    background = White,
    onBackground = BlueDark,
    onPrimary = Black,
    onSurface = WhiteGray
)

@Composable
fun DroidBankTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
