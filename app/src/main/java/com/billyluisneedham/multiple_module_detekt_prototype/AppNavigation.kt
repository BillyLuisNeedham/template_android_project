package com.billyluisneedham.multiple_module_detekt_prototype

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.billyluisneedham.multiplemoduledetektprototype.counter.Counter

internal sealed class Screen(val route: String) {
    object Counter: Screen("counter")
}

@Composable
internal fun AppNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.Counter.route) {
        addCounter()
    }
}

private fun NavGraphBuilder.addCounter() {
    composable(route = Screen.Counter.route) {
        Counter()
    }
}