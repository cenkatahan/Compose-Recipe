package com.atahan.compose_recipe.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.atahan.compose_recipe.view.screen.ProfileScreen
import com.atahan.compose_recipe.view.screen.RecipeFormScreen

fun NavGraphBuilder.topBarNavigation(
    navController: NavHostController
) {
    navigation(
        route = Graph.TOP_BAR_GRAPH,
        startDestination = Screen.Profile.route
    ) {
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }

        composable(route = Screen.RecipeForm.route) {
            RecipeFormScreen()
        }
    }
}