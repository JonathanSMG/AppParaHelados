package com.uleam.appparahelados.ui.admin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uleam.appparahelados.R
import com.uleam.appparahelados.ui.AppViewModelProvider
import com.uleam.appparahelados.ui.navigation.NavigationController
import com.uleam.appparahelados.ui.theme.md_theme_light_onSecondary

object AdminDestionation : NavigationController {
    override val route = "admin"
    override val titleRes = R.string.admin_title
}

@Composable
fun AdminScreen(navigateTopping: () -> Unit,
                navigateHelado: () -> Unit,
                viewModel: AdminViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    Scaffold(
        content = { paddingValues ->
            MainContent(
                navigateTopping = {navigateTopping()},
                navigateHelado = {navigateHelado()},
                modifier = Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun Encabezado() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Administración de Helados",
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun MainContent(navigateTopping: () -> Unit,
                navigateHelado: () -> Unit,
                modifier: Modifier = Modifier) {
    var menuVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Encabezado()
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            if (!menuVisible) {
                Button(
                    onClick = { menuVisible = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = md_theme_light_onSecondary
                    )
                ) {
                    Text("Abrir menú")
                }
            } else {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { menuVisible = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = md_theme_light_onSecondary
                        )
                    ) {
                        Text("Cerrar menú")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (menuVisible) {
            MenuContent(
                navigateTopping = {navigateTopping()},
                navigateHelado = {navigateHelado()},
                onCloseMenu = { menuVisible = false },
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)
            )
        }
    }
}

@Composable
fun MenuContent(navigateTopping: () -> Unit,
                navigateHelado: () -> Unit,
                onCloseMenu: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navigateTopping() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = md_theme_light_onSecondary
            )
        ) {
            Text("Toppings")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navigateHelado() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = md_theme_light_onSecondary
            )
        ) {
            Text("Sabores")
        }
    }
}
