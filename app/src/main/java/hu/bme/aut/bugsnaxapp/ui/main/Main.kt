package hu.bme.aut.bugsnaxapp.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun BugsnaxMainScreen() {
    val navController = rememberNavController()

    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
            composable(NavScreen.Home.route) {
                MainFragment(
                    viewModel = hiltViewModel(),
                    addViewModel = hiltViewModel()
                )
            }
        }
    }
}

sealed class NavScreen(val route: String) {
    object Home : NavScreen("Home")

    object Add : NavScreen("Add")

    object About : NavScreen("About")
}