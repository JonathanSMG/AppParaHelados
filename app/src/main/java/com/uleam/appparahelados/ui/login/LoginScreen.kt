package com.uleam.appparahelados.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uleam.appparahelados.R
import com.uleam.appparahelados.ui.AppViewModelProvider
import com.uleam.appparahelados.ui.navigation.NavigationController
import com.uleam.appparahelados.ui.theme.md_theme_light_onSecondary
import com.uleam.appparahelados.ui.theme.md_theme_light_onSurfaceVariant
import com.uleam.appparahelados.ui.theme.md_theme_light_secondary

object LoginDestinationScreen : NavigationController {
    override val route = "login"
    override val titleRes = R.string.login_title
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navigateTohome: () -> Unit,
    navigateToRegister: () -> Unit,
    viewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var correo by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    val alertDialogVisibleState = remember { mutableStateOf(false) }
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
            Encabezado()
            Spacer(modifier = Modifier.height(16.dp))

            val textFieldModifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .padding(vertical = 4.dp, horizontal = 16.dp)

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
                    viewModel.login(correo, pass)
                    navigateTohome()
                    alertDialogVisibleState.value = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = md_theme_light_onSecondary
                )
            ) {
                Text(text = "Iniciar Sesión")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¿No tienes cuenta? ",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = "Regístrate",
                    color = Color.Blue,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable { navigateToRegister() }
                )
            }
            if (alertDialogVisibleState.value) {
                InicioSesionExitosoDialog {
                    alertDialogVisibleState.value = false
                }
            }
        }
    }
    LaunchedEffect(Unit) {
        scrollState.animateScrollTo(scrollState.maxValue)
    }
}

@Composable
fun InicioSesionExitosoDialog(onClose: () -> Unit) {
    AlertDialog(
        onDismissRequest = onClose,
        title = { Text("¡Inicio de Sesión Exitoso!") },
        text = { Text("¡Has iniciado sesión exitosamente! ¿Deseas continuar?") },
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
fun Encabezado() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp)) // Espacio adicional arriba del texto
        Text(
            text = "Heladería Sammy",
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(id = R.drawable.portada),
            contentDescription = "Logo de Heladería Sammy jj",
            modifier = Modifier
                .size(200.dp)
        )
    }
}