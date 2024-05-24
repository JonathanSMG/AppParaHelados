package com.uleam.appparahelados.ui.registro

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uleam.appparahelados.R
import com.uleam.appparahelados.ui.AppViewModelProvider
import com.uleam.appparahelados.ui.navigation.NavigationDestination
import com.uleam.appparahelados.ui.theme.md_theme_light_onSecondary
import com.uleam.appparahelados.ui.theme.md_theme_light_onSurfaceVariant
import com.uleam.appparahelados.ui.theme.md_theme_light_secondary
import kotlinx.coroutines.delay

object RegistroDistinationScreen : NavigationDestination {
    override val route = "registro"
    override val titleRes = R.string.app_name

    @Composable
    override fun Content(navController: NavController) {
        TODO("Not yet implemented")
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RegistroScreen(
        viewModel: RegisterViewModel = viewModel(factory = AppViewModelProvider.Factory)
    ) {
        var nombre by remember { mutableStateOf("") }
        var correo by remember { mutableStateOf("") }
        var direccion by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }
        var telefono by remember { mutableStateOf("") }

        val alertDialogVisibleState = remember { mutableStateOf(false) }

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
                    // Validar los datos con el ViewModel
                    viewModel.onSubmitButtonClick(nombre, correo, direccion, pass, telefono)
                    // Mostrar AlertDialog solo si la validación es exitosa
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

            // Mostrar el AlertDialog si es necesario
            if (alertDialogVisibleState.value) {
                RegistroExitosoDialog {
                    alertDialogVisibleState.value = false
                }
            }
        }
      }

    @Composable
    fun RegistroExitosoDialog(onClose: () -> Unit
    ) {
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
}


