package com.uleam.appparahelados.ui.admin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
fun AdminScreen(viewModel: AdminViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    Scaffold(
        content = { paddingValues ->
            MainContent(modifier = Modifier.padding(paddingValues))
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
fun MainContent(modifier: Modifier = Modifier) {
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
                onCloseMenu = { menuVisible = false },
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)
            )
        }
    }
}

@Composable
fun MenuContent(onCloseMenu: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle Sabores click */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = md_theme_light_onSecondary
            )
        ) {
            Text("Sabores")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle Toppins click */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = md_theme_light_onSecondary
            )
        ) {
            Text("Toppins")
        }
    }
}
