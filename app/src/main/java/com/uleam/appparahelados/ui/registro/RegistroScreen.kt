package com.uleam.appparahelados.ui.registro

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
fun RegistroScreen(
    navController: NavController,
    viewModel: RegisterViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    val alertDialogVisibleState = remember { mutableStateOf(false) }
    val navigateToLogin by viewModel.navigateTo.observeAsState(false)

    LaunchedEffect(navigateToLogin) {
        if (navigateToLogin) {
            navController.navigate("login")
        }
    }

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
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(text = "Nombre") },
            modifier = textFieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = md_theme_light_onSurfaceVariant)
        )
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text(text = "Correo electrónico") },
            modifier = textFieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = md_theme_light_onSurfaceVariant)
        )
        OutlinedTextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text(text = "Dirección") },
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
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text(text = "Teléfono") },
            modifier = textFieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = md_theme_light_onSurfaceVariant)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.onSubmitButtonClick(nombre, correo, direccion, pass, telefono)
                alertDialogVisibleState.value = true
            },
            modifier = buttonModifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = md_theme_light_secondary,
                contentColor = md_theme_light_onSecondary
            )
        ) {
            Text(text = "Registrarse")
        }



        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = { navController.navigate("login") },
            modifier = buttonModifier
        ) {
            Text(text = "Iniciar sesión")
        }
    }
}

@Composable
fun RegistroExitosoDialog(onClose: () -> Unit) {
    AlertDialog(
        onDismissRequest = onClose,
        title = { Text("¡Registro exitoso!") },
        text = { Text("¡Tu registro se ha completado exitosamente! ¿Deseas iniciar sesión ahora?") },
        confirmButton = {
            Button(
                onClick = onClose,
                colors = ButtonDefaults.buttonColors(
                    containerColor = md_theme_light_secondary,
                    contentColor = md_theme_light_onSecondary
                )
            ) {
                Text("OK")
            }
        }
    )
}
