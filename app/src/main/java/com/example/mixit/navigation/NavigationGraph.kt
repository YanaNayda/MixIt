package com.example.mixit.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.mixit.welcome.WelcomeScreen
import com.example.mixit.login.LogIn
import com.example.mixit.signIn.SignIn

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome")
    object LogIn : Screen("login")
    object Home: Screen("home")
    object Cocktails: Screen("cocktails")
    object DIY: Screen("diy")
    object Game: Screen("game")
    object Advice: Screen("advice")
    object SignIn: Screen("signIn")


}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {
        composable(Screen.WelcomeScreen.route) {
            WelcomeScreen(navController)
        }
        composable(Screen.LogIn.route) { backStackEntry ->
            LogIn(navController)
        }
        composable(Screen.Home.route) { backStackEntry ->
            BottomNavigation()
        }
        composable(Screen.SignIn.route) { backStackEntry ->
            SignIn()
        }




    }
}