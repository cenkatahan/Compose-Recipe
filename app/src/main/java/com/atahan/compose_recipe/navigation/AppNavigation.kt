package com.atahan.compose_recipe.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavigation(navController: NavHostController, paddingValues: PaddingValues = PaddingValues(0.dp)) {

    NavHost(
        navController = navController,
        route = Graph.APP_GRAPH,
        startDestination = Graph.BOTTOM_NAV_GRAPH,
        modifier = Modifier.padding(paddingValues)
    ) {
        bottomNavigation(navController = navController)
        topBarNavigation(navController = navController)
        detailNavigation(navController = navController)
    }

}