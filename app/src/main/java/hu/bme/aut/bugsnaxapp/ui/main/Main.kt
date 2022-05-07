package hu.bme.aut.bugsnaxapp.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BugsnaxMainScreen() {
    MainFragment(
        viewModel = hiltViewModel(),
        addViewModel = hiltViewModel()
    )
}