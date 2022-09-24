    package com.kodexcompany.iskranavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.kodexcompany.iskranavigation.navigation.SetupNavHost
import com.kodexcompany.iskranavigation.ui.theme.IskraNavigationTheme
import kotlinx.coroutines.launch

    class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IskraNavigationTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                 Scaffold(
                     scaffoldState = scaffoldState,
                     topBar = {
                     AppBar(
                         onNavigationIconClick = {
                             scope.launch {
                             scaffoldState.drawerState.open()
                         }
                         }
                     )
                  },
                    drawerContent = {
                        DriverHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Go to home screen",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "settings",
                                    title = "Settings",
                                    contentDescription = "Go to settings screen",
                                    icon = Icons.Default.Settings
                                ),
                                MenuItem(
                                    id = "help",
                                    title = "Help",
                                    contentDescription = "Get help",
                                    icon = Icons.Default.Info

                                ),

                            ),
                            onItemClick = {
                               // println("Clicked on ${it.title}")
                            }
                        )
                    }
                ) {
                }
            }
            val navController = rememberNavController()
            SetupNavHost(navController = navController)
        }
    }
}

