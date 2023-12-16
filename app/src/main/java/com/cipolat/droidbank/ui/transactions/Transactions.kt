package com.cipolat.droidbank.ui.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem

@Composable
fun Transactions(
    modifier: Modifier = Modifier,
    transactions: List<TransactionItem>
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(transactions) {
            TransactionViewItem(Modifier.fillMaxWidth(), it)
        }
    }
}
