package com.kodexcompany.iskranavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kodexcompany.iskranavigation.screecs.MainScreen
import com.kodexcompany.iskranavigation.screecs.SplashScreen
import com.kodexcompany.iskranavigation.utils.Constants

sealed class Screens(val route: String){
    object Splash: Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main: Screens(route = Constants.Screens.MAIN_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavController) {
NavHost(navController = navController as NavHostController, startDestination = Screens.Splash.route){
    composable(route = Screens.Splash.route){SplashScreen(navController = navController)
    }
    composable(route = Screens.Main.route){MainScreen(navController = navController)
    }
}
}