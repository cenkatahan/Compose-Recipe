package com.atahan.compose_recipe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.atahan.compose_recipe.model.Screen
import com.atahan.compose_recipe.view.screen.FavoritesScreen
import com.atahan.compose_recipe.view.screen.HomeScreen
import com.atahan.compose_recipe.view.screen.MealMenuScreen

@Composable
fun BottomNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screen.Favorites.route){
            FavoritesScreen()
        }
        composable(route = Screen.MealMenu.route){
            MealMenuScreen()
        }
    }
    
}