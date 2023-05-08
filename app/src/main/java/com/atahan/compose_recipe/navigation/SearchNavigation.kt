package com.atahan.compose_recipe.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.atahan.compose_recipe.view.screen.SearchScreen

fun NavGraphBuilder.searchNavigation(
    navController: NavHostController
) {
    navigation(
        route = Graph.SEARCH_GRAPH,
        startDestination = Screen.Search.route
    ) {
        composable(route = Screen.Search.route) {
            SearchScreen()
        }
    }
}