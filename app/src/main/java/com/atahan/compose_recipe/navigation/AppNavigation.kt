package com.atahan.compose_recipe.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.atahan.compose_recipe.model.Screen
import com.atahan.compose_recipe.view.screen.*

@Composable
fun AppNavigation(navController: NavHostController, paddingValues: PaddingValues) {

    NavHost(navController = navController, startDestination = Screen.Home.route, modifier = Modifier.padding(paddingValues)){
        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screen.Favorites.route){
            FavoritesScreen()
        }
        composable(route = Screen.MealMenu.route){
            MealMenuScreen()
        }

        composable(route = Screen.Profile.route){
            ProfileScreen()
        }

        composable(route = Screen.RecipeForm.route){
            RecipeFormScreen()
        }

        composable(route = Screen.RecipeDetail.route){
            RecipeFormScreen()
        }
    }
    
}