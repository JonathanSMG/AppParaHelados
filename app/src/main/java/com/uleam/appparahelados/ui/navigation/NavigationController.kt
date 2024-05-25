package com.uleam.appparahelados.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uleam.appparahelados.ui.login.LoginDestinationScreen
import com.uleam.appparahelados.ui.login.LoginScreen
import com.uleam.appparahelados.ui.principal.PrincipalDestination
import com.uleam.appparahelados.ui.principal.PrincipalScreen
import com.uleam.appparahelados.ui.registro.RegistroDistinationScreen
import com.uleam.appparahelados.ui.registro.RegistroScreen

@Composable
fun NavigationController(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = LoginDestinationScreen.route,
        modifier = modifier
    ) {
        composable(route = LoginDestinationScreen.route) {
            LoginScreen(
                navigateTohome = { navController.navigate(PrincipalDestination.route) },
                navigateToRegister = {navController.navigate(RegistroDistinationScreen.route) }
            )
        }
        composable(route = RegistroDistinationScreen.route) {
            RegistroScreen(
                navigatetoLogin = { navController.navigate(LoginDestinationScreen.route) })
        }
        composable(route = PrincipalDestination.route) {
            PrincipalScreen(
                navigatetoLogin = { navController.navigate(LoginDestinationScreen.route) })
        }
    }
}