package com.atahan.compose_recipe.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.atahan.compose_recipe.view.screen.*

@Composable
fun AppNavigation(navController: NavHostController, paddingValues: PaddingValues = PaddingValues(0.dp)) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(paddingValues)
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

        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }

        composable(route = Screen.RecipeForm.route) {
            RecipeFormScreen()
        }

        composable(
            route = "${Screen.RecipeDetail.route}/{recipeId}",
            arguments = listOf(
                navArgument(name = "recipeId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            backStackEntry.arguments?.getInt("recipeId")?.let { recipeId ->
                RecipeDetailScreen(recipeId = recipeId)
            }

        }
    }

}