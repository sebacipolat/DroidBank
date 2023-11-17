package com.cipolat.droidbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cipolat.droidbank.usecase.bottomnav.BottomNav
import com.cipolat.droidbank.usecase.cards.CardScreen
import com.cipolat.droidbank.usecase.theme.DroidBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            var bottomBarState = rememberSaveable { true }
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            DroidBankTheme {
                BottomNav(this@MainActivity, bottomBarState, navController)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DroidBankTheme {
       // HomeScreen()
        CardScreen()
    }
}