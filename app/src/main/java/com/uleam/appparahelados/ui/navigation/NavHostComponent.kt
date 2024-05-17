package com.uleam.appparahelados.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uleam.appparahelados.ui.registro.RegistroScreen

object NavigationController {
    @Composable
    fun NavHostComponent() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = RegistroScreen.route) {
            composable(RegistroScreen.route) {
                RegistroScreen.Content(navController)
            }
            // Puedes agregar más rutas y pantallas aquí según sea necesario
        }
    }
}
