package com.cipolat.droidbank.ui.widgets.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cipolat.droidbank.R
import com.cipolat.droidbank.network.Resource

@Composable
fun ErrorPlaceHolder(
    modifier: Modifier = Modifier,
    errorType: Resource.ErrorType,
    onClick: () -> Unit
) {
    when (errorType) {
        Resource.ErrorType.NETWORK -> {
            ErrorView(
                modifier,
                stringResource(id = R.string.connection_error_title),
                stringResource(id = R.string.connection_error_message),
                stringResource(id = R.string.connection_error_btn_label),
                R.drawable.connection_error,
                onClick
            )
        }

        Resource.ErrorType.API_ERROR -> {
            ErrorView(
                modifier,
                stringResource(id = R.string.server_error_title),
                stringResource(id = R.string.server_error_message),
                "",
                R.drawable.error,
                onClick
            )
        }
    }
}