package com.uleam.appparahelados.ui.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uleam.appparahelados.ui.registro.RegistroScreen

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppParaHelados{
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}

@Composable
fun Navigation(navController: NavController) {
    NavHost(navController, startDestination = RegistroScreen.route) {
        composable(RegistroScreen.route) { RegistroScreen.Content(navController) }
        // Añade más destinos de navegación según sea necesario
    }
}
