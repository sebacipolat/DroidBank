package com.cipolat.droidbank.ui.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cipolat.droidbank.R
import com.cipolat.droidbank.data.transactions.remote.model.TransactionItem
import com.cipolat.droidbank.ui.theme.poppins

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
