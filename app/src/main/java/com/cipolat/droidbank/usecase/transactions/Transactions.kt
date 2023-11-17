package com.cipolat.droidbank.usecase.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Transactions(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier=modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            TransactionHeader()
        }
        item {
            TransactionItem()
        }
        item {
            TransactionItem()
        }
        item {
            TransactionItem()
        }
    }
}