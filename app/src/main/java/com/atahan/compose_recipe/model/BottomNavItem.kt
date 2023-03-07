package com.atahan.compose_recipe.model

sealed class BottomNavItem(val route: String, val icon: Int, val selectedIcon: Int) {

    object Home: BottomNavItem("Home", 0, 0)
    object Favorites: BottomNavItem("Favorites", 0, 0)
    object MealMenu: BottomNavItem("Meal Menu", 0, 0)

}
