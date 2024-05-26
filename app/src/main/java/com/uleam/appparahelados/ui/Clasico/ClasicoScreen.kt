package com.uleam.appparahelados.ui.Clasico


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.uleam.appparahelados.data.Helado.Helado
import com.uleam.appparahelados.ui.AppViewModelProvider
import com.uleam.appparahelados.ui.admin.AdminViewModel

@Composable
fun ClasicoScreen(navController: NavHostController,
                  viewModel: ClasicoViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val cantidades by viewModel.cantidadHelados.collectAsState()
    val sabores by viewModel.heladoUiState.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Spacer(modifier = Modifier.height(60.dp))

        if (sabores.clasicoList.isEmpty()) {
            Text(
                text = "No se encuentran disponibles actualmente ningun helado.",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        } else {
            sabores.clasicoList.forEach { helado ->
                val cantidad = cantidades[helado.id] ?: 0
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = helado.sabor,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = helado.descripcion,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Precio: $${helado.precioBase}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { viewModel.decrementarCantidad(helado.id) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Decrementar")
                        }
                        Text(
                            text = "$cantidad",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        IconButton(onClick = { viewModel.incrementarCantidad(helado.id) }) {
                            Icon(Icons.Default.Add, contentDescription = "Incrementar")
                        }
                    }
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { navController.navigate("principal") }) {
                Text("Regresar al inicio")
            }
            Button(onClick = { navController.navigate("user_topping") }) {
                Text("Toppings")
            }
        }
    }
}


