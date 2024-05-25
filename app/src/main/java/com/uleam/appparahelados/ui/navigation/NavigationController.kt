package com.uleam.appparahelados.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uleam.appparahelados.ui.admin.AdminDestionation
import com.uleam.appparahelados.ui.admin.AdminScreen
import com.uleam.appparahelados.ui.login.LoginDestinationScreen
import com.uleam.appparahelados.ui.login.LoginScreen
import com.uleam.appparahelados.ui.principal.PrincipalDestionation
import com.uleam.appparahelados.ui.principal.PrincipalScreen
import com.uleam.appparahelados.ui.registro.RegistroDistinationScreen
import com.uleam.appparahelados.ui.registro.RegistroScreen
import com.uleam.appparahelados.ui.splash.SplashScreen
import com.uleam.appparahelados.ui.Clasico.ClasicoScreen

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
                navigateTohome = { navController.navigate(PrincipalDestionation.route) },
                navigateToRegister = { navController.navigate(RegistroDistinationScreen.route) } ,
                navigateToAdmin = {navController.navigate(AdminDestionation.route )})
        }
        composable(route = RegistroDistinationScreen.route) {
            RegistroScreen(
                navigateToLogin = { navController.navigate(LoginDestinationScreen.route) })
        }
        composable(route = PrincipalDestionation.route) {
            PrincipalScreen()
        }
        composable(route = AdminDestionation.route) {
            AdminScreen()
        }
        composable(route = "clasico") {
            ClasicoScreen(navController = navController)
        }
    }
}
