package com.uleam.appparahelados.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uleam.appparahelados.ui.registro.RegistroDistinationScreen

object NavigationController {
    @Composable
    fun NavHostComponent() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = RegistroDistinationScreen.route) {
            composable(RegistroDistinationScreen.route) {
                RegistroDistinationScreen.RegistroScreen()
            }
        }
    }
}