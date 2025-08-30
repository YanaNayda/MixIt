package com.example.mixit.navigation

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome")
    object LogIn : Screen("login")
    object Home: Screen("home")
    object Cocktails: Screen("cocktails")
    object DIY: Screen("diy")
    object Game: Screen("game")
    object Advice: Screen("advice")
    object SignIn: Screen("signIn")
    object Profile: Screen("profile")

}