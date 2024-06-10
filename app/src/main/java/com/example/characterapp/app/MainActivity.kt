package com.example.characterapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.characterapp.app.ui.compose.home.HomeScreen
import com.example.characterapp.app.ui.compose.screens.simpsons.SimpsonDetailsScreen
import com.example.characterapp.app.ui.compose.screens.simpsons.SimpsonListScreen
import com.example.characterapp.app.ui.compose.screens.wire.WireDetailsScreen
import com.example.characterapp.app.ui.compose.screens.wire.WireListScreen
import com.example.characterapp.app.ui.theme.CharacterAppTheme
import com.example.characterapp.common.nav.NavRoutes
import com.example.characterapp.common.nav.routes.SimpsonsNavRoute
import com.example.characterapp.common.nav.routes.WireNavRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                CharacterApp(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterApp(navController: NavHostController) {
    val topState = remember { mutableStateOf(false) }
    val bottomState = remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val barTitle = remember(currentRoute) {
        when (currentRoute) {
            NavRoutes.ROUTE_SIMPSONS -> "Simpsons"
            NavRoutes.Simpson.route -> "Simpson Details"
            NavRoutes.ROUTE_WIRE -> "Wire"
            NavRoutes.Wire.route -> "Wire Details"
            else -> "Details"
        }
    }

    when (navBackStackEntry?.destination?.route) {
        NavRoutes.Home.route,
        NavRoutes.Home.route -> {
            bottomState.value = true
            topState.value = false
        }
        else -> {
            bottomState.value = false
            topState.value = true
        }
    }

    Scaffold(
        topBar = {
            if (topState.value) {
                TopAppBar(
                    title = { Text(barTitle) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        }
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.ROUTE_HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(NavRoutes.ROUTE_SIMPSONS) {
                SimpsonListScreen(viewModel = hiltViewModel(), navController = navController)
            }
            composable(
                route = NavRoutes.Simpson.route,
                arguments = NavRoutes.Simpson.arguments
            ) {
                SimpsonDetailsScreen(SimpsonsNavRoute.Details.fromEntry(it))
            }
            composable(NavRoutes.ROUTE_WIRE) {
                WireListScreen(viewModel = hiltViewModel(), navController = navController)
            }
            composable(
                route = NavRoutes.Wire.route,
                arguments = NavRoutes.Wire.arguments
            ) {
                WireDetailsScreen(WireNavRoute.Details.fromEntry(it))
            }
        }

    }
}
