package com.cipolat.droidbank.ui.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cipolat.droidbank.ui.cards.CardScreen
import com.cipolat.droidbank.ui.home.HomeScreen
import com.cipolat.droidbank.ui.navigation.routes.NavigationItem
import com.cipolat.droidbank.ui.transactions.TransactionsScreen

@Composable
fun NavigationGraph(context: Activity, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(context = context)
        }
        composable(NavigationItem.Cards.route) {
            CardScreen()
        }
        composable(NavigationItem.Transaction.route) {
            TransactionsScreen()
        }
    }
}
