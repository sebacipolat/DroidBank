package com.cipolat.droidbank.usecase.widgets.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cipolat.droidbank.usecase.widgets.button.CircleButton

@Composable
fun Menu(modifier: Modifier = Modifier, items: ArrayList<MenuItem>) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(items = items, itemContent = { item ->
            CircleButton(
                iconIDLight = item.iconLight,
                iconIDDark = item.iconDark,
                text = item.text
            ) {

            }
        })
    }
}