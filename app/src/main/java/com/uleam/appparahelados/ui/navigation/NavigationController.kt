package com.uleam.appparahelados.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.uleam.appparahelados.ui.admin.topping.entry.ToppingEntryDestination
import com.uleam.appparahelados.ui.admin.topping.entry.ToppingEntryScreen
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
import com.uleam.appparahelados.ui.admin.topping.ToppingDestination
import com.uleam.appparahelados.ui.admin.topping.ToppingScreen
import com.uleam.appparahelados.ui.admin.topping.details.ToppingDetailsDestination
import com.uleam.appparahelados.ui.admin.topping.details.ToppingDetailsScreen
import com.uleam.appparahelados.ui.admin.topping.edit.ToppingEditDestination
import com.uleam.appparahelados.ui.admin.topping.edit.ToppingEditScreen

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
            PrincipalScreen(navController = navController) // Pasar navController aquí
        }
        composable(route = AdminDestionation.route) {
            AdminScreen(
                navigateTopping = { navController.navigate(ToppingDestination.route) },
                navigateHelado = { navController.navigate(ToppingDestination.route) })
        }
        composable(route = "clasico") {
            ClasicoScreen(navController = navController)
        }
        composable(route = ToppingDestination.route) {
            ToppingScreen(
                navigateToItemEntry = { navController.navigate(ToppingEntryDestination.route) },
                navigateToItemUpdate = {
                    navController.navigate("${ToppingDetailsDestination.route}/${it}")
                },
                navigateAdmin = { navController.navigate(AdminDestionation.route) },
            )
        }
        composable(route = ToppingEntryDestination.route) {
            ToppingEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = ToppingDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ToppingDetailsDestination.toppingIdArg) {
                type = NavType.IntType
            })
        ) {
            ToppingDetailsScreen(
                navigateToEditItem = { navController.navigate("${ToppingEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = ToppingEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ToppingEditDestination.toppingIdArg) {
                type = NavType.IntType
            })
        ) {
            ToppingEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}
