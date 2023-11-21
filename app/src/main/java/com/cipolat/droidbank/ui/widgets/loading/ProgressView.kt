package com.cipolat.droidbank.ui.widgets.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cipolat.droidbank.ui.theme.BlueDark

@Composable
fun ProgressView(modifier: Modifier = Modifier) {
    val strokeWidth = 5.dp
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = modifier.height(150.dp), color = BlueDark, strokeWidth = strokeWidth
        )
    }
}