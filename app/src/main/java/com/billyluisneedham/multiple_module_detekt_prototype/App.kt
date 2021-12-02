package com.billyluisneedham.multiple_module_detekt_prototype

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
internal fun App() {
    val navController = rememberNavController()

    Scaffold {
        AppNavigation(navController = navController)
    }
}