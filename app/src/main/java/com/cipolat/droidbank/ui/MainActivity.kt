package com.cipolat.droidbank.ui

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
import com.cipolat.droidbank.BuildConfig
import com.cipolat.droidbank.data.network.client.HttpClient
import com.cipolat.droidbank.ui.bottomnav.BottomNav
import com.cipolat.droidbank.ui.cards.CardScreen
import com.cipolat.droidbank.ui.theme.DroidBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            var bottomBarState = rememberSaveable { true }
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            HttpClient.init(BuildConfig.BASE_URL)
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
