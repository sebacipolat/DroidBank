package com.cipolat.droidbank.ui.home

import com.cipolat.droidbank.R
import com.cipolat.droidbank.ui.widgets.menu.MenuItem

object HomeMenu {
    fun getList(): ArrayList<MenuItem> {
        val list = ArrayList<MenuItem>()
        list.add(
            MenuItem(
                iconLight = R.drawable.arrow_dark,
                iconDark = R.drawable.arrow_dark,
                "Sent"
            )
        )
        list.add(
            MenuItem(
                iconLight = R.drawable.arrow_dark,
                iconDark = R.drawable.arrow_dark,
                "Receive"
            )
        )
        list.add(
            MenuItem(
                iconLight = R.drawable.arrow_dark,
                iconDark = R.drawable.arrow_dark,
                "Loan"
            )
        )
        list.add(
            MenuItem(
                iconLight = R.drawable.arrow_dark,
                iconDark = R.drawable.arrow_dark,
                "Topup"
            )
        )
        return list
    }
}