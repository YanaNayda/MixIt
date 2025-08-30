package com.example.mixit.navigation.botttom_navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.advice.Advice
import com.example.cocktails.Cocktails
import com.example.diy.DIY
import com.example.game.Game
import com.example.home.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mixit.navigation.Screen
import com.example.mixit.navigation.top_navigation.TopNavigationBar


@Composable
fun BottomNavigation( ) {
    val bottomNavController = rememberNavController()
        Scaffold(
            topBar = {
                TopNavigationBar(
                    navController = bottomNavController,
                    onProfileClick = { bottomNavController.navigate("profile")
                }
            )
            },
            bottomBar = {
                BottomNavigationBar(
                    navController = bottomNavController,
                    modifier = Modifier
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = bottomNavController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Home.route) { Home() }
                composable(Screen.Cocktails.route) { Cocktails() }
                composable(Screen.DIY.route) { DIY() }
                composable(Screen.Game.route) { Game() }
                composable(Screen.Advice.route) { Advice() }

            }
        }
    }