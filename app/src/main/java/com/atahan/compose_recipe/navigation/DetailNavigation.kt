package com.atahan.compose_recipe.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.atahan.compose_recipe.view.screen.RecipeDetailScreen

fun NavGraphBuilder.detailNavigation(
    navController: NavHostController
) {

    navigation(
        route = Graph.DETAIL_GRAPH,
        startDestination = Screen.RecipeDetail.route

    ) {
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