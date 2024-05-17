package com.uleam.appparahelados.ui.registro

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inventory.ui.navigation.NavigationDestination
import com.uleam.appparahelados.R

object RegistroScreen : NavigationDestination {
    override val route = "registro"
    override val titleRes = R.string.app_name

    @SuppressLint("UnrememberedMutableState")
    @Composable
    override fun Content(navController: NavController) {
        // Declaración de los campos del formulario
        val nombreState = mutableStateOf(TextFieldValue())
        val correoState = mutableStateOf(TextFieldValue())
        val contraseñaState = mutableStateOf(TextFieldValue())
        val telefonoState = mutableStateOf(TextFieldValue())
        val direccionState = mutableStateOf(TextFieldValue())

        // Mostrar los campos del formulario
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Registro", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(16.dp))

                // Campo para el nombre
                TextField(
                    value = nombreState.value,
                    onValueChange = { nombreState.value = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo para el correo electrónico
                TextField(
                    value = correoState.value,
                    onValueChange = { correoState.value = it },
                    label = { Text("Correo electrónico") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo para la contraseña
                TextField(
                    value = contraseñaState.value,
                    onValueChange = { contraseñaState.value = it },
                    label = { Text("Contraseña") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo para el teléfono
                TextField(
                    value = telefonoState.value,
                    onValueChange = { telefonoState.value = it },
                    label = { Text("Teléfono") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo para la dirección
                TextField(
                    value = direccionState.value,
                    onValueChange = { direccionState.value = it },
                    label = { Text("Dirección") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Botón de registro
                Button(onClick = {
                    // Aquí puedes agregar la lógica para el registro
                    // Por ejemplo, puedes llamar a una función en el ViewModel
                    // para realizar el registro del usuario
                }) {
                    Text("Registrarse")
                }
            }
        }
    }
}
