package com.example.mixit.navigation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.navigation.compose.rememberNavController
import com.example.advice.Advice
import com.example.cocktails.Cocktails
import com.example.diy.DIY
import com.example.game.Game
import com.example.home.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun BottomNavigation() {
        val bottomNavController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController = bottomNavController ,
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