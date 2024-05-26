package com.uleam.appparahelados.ui.Clasico.topppings


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavHostController
import com.uleam.appparahelados.data.Topping.Topping
import com.uleam.appparahelados.ui.AppViewModelProvider

@Composable
fun UserToppingScreen(navController: NavHostController,
                      viewModel: UserToppingViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val cantidades by viewModel.cantidadToppings.collectAsState()
    val toppings by viewModel.toppingUiState.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Spacer(modifier = Modifier.height(60.dp))

        if (toppings.toppingList.isEmpty()) {
            Text(
                text = "No se encuentran disponibles actualmente ningun topping.",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        } else {
            toppings.toppingList.forEach { topping ->
                val cantidad = cantidades[topping.id] ?: 0
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = topping.nombre,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "Precio: $${topping.precio}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { viewModel.decrementarCantidad(topping.id) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Decrementar")
                        }
                        Text(
                            text = "$cantidad",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        IconButton(onClick = { viewModel.incrementarCantidad(topping.id) }) {
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
            Button(onClick = { navController.navigate("interfaz_helado") }) {
                Text("Helados")
            }
        }
    }
}
