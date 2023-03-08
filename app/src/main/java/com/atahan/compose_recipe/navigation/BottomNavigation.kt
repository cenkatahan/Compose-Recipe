package com.atahan.compose_recipe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.atahan.compose_recipe.model.Screens
import com.atahan.compose_recipe.view.screen.HomeScreen

@Composable
fun BottomNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.Home.route){
        composable(route = Screens.Home.route){
            HomeScreen()
        }
        composable(route = Screens.Favorites.route){
//            Favorites()
        }
        composable(route = Screens.MealMenu.route){
//            MealMenu()
        }
    }
    
}