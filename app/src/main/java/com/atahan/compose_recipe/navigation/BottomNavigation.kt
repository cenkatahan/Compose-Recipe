package com.atahan.compose_recipe.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.atahan.compose_recipe.view.screen.FavoritesScreen
import com.atahan.compose_recipe.view.screen.HomeScreen
import com.atahan.compose_recipe.view.screen.MealMenuScreen
import com.atahan.compose_recipe.view.screen.ProfileScreen

fun NavGraphBuilder.bottomNavigation(
    navController: NavHostController
) {
    navigation(
        route = Graph.BOTTOM_NAV_GRAPH,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.Favorites.route) {
            FavoritesScreen(navController)
        }
        composable(route = Screen.MealMenu.route) {
            MealMenuScreen(navController)
        }
    }
}