package com.cipolat.droidbank.ui.home.components.menu

import com.cipolat.droidbank.R
import com.cipolat.droidbank.ui.widgets.menu.MenuItem

object HomeMenu {
    fun getList(): ArrayList<MenuItem> {
        val list = ArrayList<MenuItem>()
        list.add(
            MenuItem(
                iconLight = R.drawable.arrow_light,
                iconDark = R.drawable.arrow_dark,
                "Sent"
            )
        )
        list.add(
            MenuItem(
                iconLight = R.drawable.receive_ligth,
                iconDark = R.drawable.receive_dark,
                "Receive"
            )
        )
        list.add(
            MenuItem(
                iconLight = R.drawable.loan_light,
                iconDark = R.drawable.loan_dark,
                "Loan"
            )
        )
        list.add(
            MenuItem(
                iconLight = R.drawable.qr_ligth,
                iconDark = R.drawable.qr_dark,
                "QR Pay"
            )
        )
        return list
    }
}
