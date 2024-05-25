package com.uleam.appparahelados.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uleam.appparahelados.ui.login.LoginDestinationScreen
import com.uleam.appparahelados.ui.login.LoginScreen
import com.uleam.appparahelados.ui.registro.RegistroDistinationScreen
import com.uleam.appparahelados.ui.registro.RegistroScreen
import com.uleam.appparahelados.ui.splash.SplashScreen

@Composable
fun NavigationController(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = "splash",
        modifier = modifier
    ) {
        composable(route = "splash") {
            SplashScreen(navController = navController)
        }
        composable(route = LoginDestinationScreen.route) {
            LoginScreen(
                navigateTohome = { navController.navigate(RegistroDistinationScreen.route) },
                navigateToRegister = { navController.navigate(RegistroDistinationScreen.route) }
            )
        }
        composable(route = RegistroDistinationScreen.route) {
            RegistroScreen(
                navigateToLogin = { navController.navigate(LoginDestinationScreen.route) })
        }
    }
}
