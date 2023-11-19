package com.cipolat.droidbank.ui.bottomnav

import android.app.Activity
import android.view.WindowManager
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cipolat.droidbank.ui.navigation.NavigationGraph

@Composable
fun BottomNav(context: Activity, bottomBarState: Boolean, navController: NavHostController) {
    //val systemUiController = rememberSystemUiController()
    val backgrColor = MaterialTheme.colors.background
    context.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    SideEffect {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        /*systemUiController.setStatusBarColor(
            color = backgrColor,
            darkIcons = !context.isDarkMode()
        )*/
    }

    Scaffold(modifier = Modifier
        .systemBarsPadding(),
        bottomBar = {
            BottomNavigationBar(
                context,
                bottomBarState,
                navController = navController
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationGraph(
                navController = navController,
                context = context
            )
        }
    }
}