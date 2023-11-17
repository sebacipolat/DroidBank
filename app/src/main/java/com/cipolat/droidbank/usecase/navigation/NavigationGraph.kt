package com.cipolat.droidbank.usecase.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cipolat.droidbank.usecase.cards.CardScreen
import com.cipolat.droidbank.usecase.home.HomeScreen
import com.cipolat.droidbank.usecase.navigation.routes.NavigationItem
import com.cipolat.droidbank.usecase.transactions.TransactionsScreen

@Composable
fun NavigationGraph(context: Activity, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Cards.route) {
            CardScreen()
        }
        composable(NavigationItem.Transaction.route) {
            TransactionsScreen()
        }
    }
}