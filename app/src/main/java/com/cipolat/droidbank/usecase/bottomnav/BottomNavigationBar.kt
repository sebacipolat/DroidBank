package com.cipolat.droidbank.usecase.bottomnav

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.cipolat.droidbank.R
import com.cipolat.droidbank.usecase.theme.Blue

@Composable
fun BottomNavigationBar(context: Context, visibility: Boolean, navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    AnimatedVisibility(
        visible = visibility,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation(
                backgroundColor = colorResource(id = R.color.white), contentColor = Blue
            ) {

                itemsBottom.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(id = item.icon), contentDescription = item.title
                            )
                        },
                        selectedContentColor = Blue,
                        unselectedContentColor = Blue.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentRoute == item.navItem.route,
                        onClick = {
                            navController.navigate(item.navItem.route) {
                                navController.graph.startDestinationRoute?.let { screenRoute ->
                                    popUpTo(screenRoute) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        })
}