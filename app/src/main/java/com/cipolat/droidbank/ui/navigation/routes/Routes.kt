package com.cipolat.droidbank.ui.navigation.routes

sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object Cards : NavigationItem(Screen.CARDS.name)
    object Transaction : NavigationItem(Screen.TRANSACTION.name)
}

enum class Screen {
    HOME,
    CARDS,
    TRANSACTION
}