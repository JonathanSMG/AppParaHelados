package com.uleam.appparahelados.ui.principal

import PrincipalViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.uleam.appparahelados.R
import com.uleam.appparahelados.ui.AppViewModelProvider
import com.uleam.appparahelados.ui.navigation.NavigationController
import com.uleam.appparahelados.ui.theme.md_theme_light_onSecondary

object PrincipalDestionation : NavigationController {
    override val route = "principal"
    override val titleRes = R.string.registros_title
}

@Composable
fun PrincipalScreen(
    navController: NavHostController,
    viewModel: PrincipalViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val comentario = viewModel.generateRandomComment()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Comentarios",
                            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = comentario,
                            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, end = 16.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        },
        content = { paddingValues ->
            MainContent(modifier = Modifier.padding(paddingValues), navController = navController)
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

@Composable
fun MainContent(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Encabezado()
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("clasico") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = md_theme_light_onSecondary
            )

        ) {
            Text("Helado Clásico")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = md_theme_light_onSecondary
            )
        ) {
            Text("Helado Personalizado")
        }
    }
}
