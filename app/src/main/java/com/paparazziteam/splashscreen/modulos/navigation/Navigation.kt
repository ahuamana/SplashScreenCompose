package com.paparazziteam.splashscreen.modulos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paparazziteam.splashscreen.modulos.login.LoginScreen
import com.paparazziteam.splashscreen.modulos.splash.SplashScreen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

@Composable
fun NavigationRoot() {
    //Nav host composable
    val navController = rememberNavController()

    //Nav graph
    NavHost(navController = navController, startDestination = ScreenRoot.SplashScreen.route){
        composable(ScreenRoot.SplashScreen.route){
            LaunchedEffect(key1 = null){
                delay(2.seconds)
                navController.popBackStack()
                navController.navigate(ScreenRoot.LoginScreen.route)
            }

            SplashScreen()
        }

        composable(ScreenRoot.LoginScreen.route){
            LoginScreen()
        }
    }
}

sealed class ScreenRoot(val route: String) {
    object SplashScreen : ScreenRoot("splash")
    object LoginScreen : ScreenRoot("login")
}