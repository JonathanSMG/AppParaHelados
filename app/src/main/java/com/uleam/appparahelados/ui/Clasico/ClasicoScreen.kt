package com.uleam.appparahelados.ui.Clasico


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
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
import com.uleam.appparahelados.data.Helado.Helado

@Composable
fun ClasicoScreen(navController: NavController, viewModel: ClasicoViewModel = viewModel()) {
    val helados by viewModel.helados.collectAsState()
    val cantidadHelados by viewModel.cantidadHelados.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(helados) { helado ->
                HeladoItem(
                    helado = helado,
                    cantidad = cantidadHelados[helado.id] ?: 0,
                    onIncrementar = { viewModel.incrementarCantidad(helado.id) },
                    onDecrementar = { viewModel.decrementarCantidad(helado.id) }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { navController.navigate("inicio") }) {
                Text("Regresar al inicio")
            }
            Button(onClick = { navController.navigate("carrito") }) {
                Text("Ir al carrito de compra")
            }
        }
    }
}

@Composable
fun HeladoItem(
    helado: Helado,
    cantidad: Int,
    onIncrementar: () -> Unit,
    onDecrementar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = helado.nombre, style = MaterialTheme.typography.bodyLarge)
        Text(text = helado.descripcion)
        Text(text = "Precio: $${helado.precioBase}")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = onDecrementar) {
                Icon(Icons.Default.Delete, contentDescription = "Decrementar")
            }

            Text(text = cantidad.toString())
            IconButton(onClick = onIncrementar) {
                Icon(Icons.Default.Add, contentDescription = "Incrementar")
            }
        }
    }
}
