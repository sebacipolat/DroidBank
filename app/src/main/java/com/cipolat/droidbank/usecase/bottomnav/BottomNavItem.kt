package com.cipolat.droidbank.usecase.bottomnav

import androidx.annotation.Keep
import com.cipolat.droidbank.R
import com.cipolat.droidbank.usecase.navigation.routes.NavigationItem

@Keep
sealed class BottomNavItem(var title: String, var icon: Int, var navItem: NavigationItem) {
    object Home : BottomNavItem("Home", R.drawable.home_bottom_icon, NavigationItem.Home)
    object Cards : BottomNavItem("Cards", R.drawable.wallet_icon, NavigationItem.Cards)
    object Transactions :
        BottomNavItem("Transactions", R.drawable.statistic_bottom_icon,NavigationItem.Transaction)
}

val itemsBottom = listOf(
    BottomNavItem.Home,
    BottomNavItem.Cards,
    BottomNavItem.Transactions,
)