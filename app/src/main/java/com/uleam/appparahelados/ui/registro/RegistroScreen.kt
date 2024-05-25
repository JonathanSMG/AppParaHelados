package com.uleam.appparahelados.ui.registro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uleam.appparahelados.R
import com.uleam.appparahelados.ui.AppViewModelProvider
import com.uleam.appparahelados.ui.navigation.NavigationController
import com.uleam.appparahelados.ui.theme.md_theme_light_onSecondary
import com.uleam.appparahelados.ui.theme.md_theme_light_onSurfaceVariant
import com.uleam.appparahelados.ui.theme.md_theme_light_secondary

object RegistroDistinationScreen : NavigationController {
    override val route = "registro"
    override val titleRes = R.string.registros_title
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(
    navigateToLogin: () -> Unit,
    viewModel: RegisterViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val alertDialogVisibleState = remember { mutableStateOf(false) }
    val showErrorDialog = remember { mutableStateOf(false) }
    val errorMessage = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Encabezado { navigateToLogin() }

            Spacer(modifier = Modifier.height(16.dp))

            val textFieldModifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .padding(vertical = 4.dp, horizontal = 16.dp)

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
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text(text = "Teléfono") },
                modifier = textFieldModifier,
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = md_theme_light_onSurfaceVariant)
            )

            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text(text = "Contraseña") },
                modifier = textFieldModifier,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisibility)
                        painterResource(id = R.drawable.visibility)
                    else painterResource(id = R.drawable.visible)

                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(painter = image, contentDescription = if (passwordVisibility) "Ocultar contraseña" else "Mostrar contraseña")
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = md_theme_light_onSurfaceVariant),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (nombre.isEmpty() || correo.isEmpty() || direccion.isEmpty() || pass.isEmpty() || telefono.isEmpty()) {
                        errorMessage.value = "Todos los campos son obligatorios."
                        showErrorDialog.value = true
                    } else {
                        viewModel.onSubmitButtonClick(nombre, correo, direccion, pass, telefono)
                        alertDialogVisibleState.value = true
                    }
                },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
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

            if (showErrorDialog.value) {
                AlertDialog(
                    onDismissRequest = { showErrorDialog.value = false },
                    title = { Text("Error") },
                    text = { Text(errorMessage.value) },
                    confirmButton = {
                        Button(
                            onClick = { showErrorDialog.value = false },
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
    }
    LaunchedEffect(Unit) {
        scrollState.animateScrollTo(scrollState.maxValue)
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

@Composable
fun Encabezado(onBackPressed: () -> Unit) {
    Surface(
        color = Color.Red, // Fondo rojo para el encabezado
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp) // Padding superior para mover el encabezado hacia abajo
            .height(200.dp) // Altura del encabezado
            .padding(horizontal = 4.dp, vertical = 8.dp), // Padding del encabezado
        shape = RoundedCornerShape(16.dp) // Redondear el borde del Surface del encabezado
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = onBackPressed,
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Botón de regresar",
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp)) // Espacio entre el botón y el texto
            Text(
                text = "CREA TU CUENTA",
                color = Color.White, // Color de texto blanco para el encabezado
                fontSize = 50.sp, // Tamaño de fuente del encabezado
                fontWeight = FontWeight.Bold,
                lineHeight = 48.sp, // Interlineado del encabezado
                modifier = Modifier.padding(start = 16.dp) // Ajuste de espacio
            )
        }
    }

}
