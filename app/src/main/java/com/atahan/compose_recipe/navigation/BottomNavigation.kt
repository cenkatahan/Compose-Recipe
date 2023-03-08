package com.atahan.compose_recipe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.atahan.compose_recipe.model.Screen
import com.atahan.compose_recipe.view.screen.HomeScreen

@Composable
fun BottomNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route){
            HomeScreen()
        }
        composable(route = Screen.Favorites.route){
//            Favorites()
        }
        composable(route = Screen.MealMenu.route){
//            MealMenu()
        }
    }
    
}