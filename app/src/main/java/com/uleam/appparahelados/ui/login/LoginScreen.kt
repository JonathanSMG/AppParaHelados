package com.uleam.appparahelados.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uleam.appparahelados.ui.AppViewModelProvider
import com.uleam.appparahelados.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var correo by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val textFieldModifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)

        val buttonModifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text(text = "Correo electrónico") },
            modifier = textFieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = md_theme_light_onSurfaceVariant)
        )
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text(text = "Contraseña") },
            modifier = textFieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = md_theme_light_onSurfaceVariant)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.onLoginButtonClick(correo, pass)
            },
            modifier = buttonModifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = md_theme_light_secondary,
                contentColor = md_theme_light_onSecondary
            )
        ) {
            Text(text = "Iniciar sesión")
        }

        val loginSuccessful by viewModel.loginSuccessful.observeAsState(false)

        LaunchedEffect(loginSuccessful) {
            if (loginSuccessful) {
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }

        val loginError by viewModel.loginError.observeAsState()

        if (loginError != null) {
            Text(text = loginError!!, color = MaterialTheme.colorScheme.error)
        }
    }
}
