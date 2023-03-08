package com.atahan.compose_recipe.model

sealed class Screens(val route: String, val icon: Int, val selectedIcon: Int) {

    object Home: Screens("Home", 0, 0)
    object Favorites: Screens("Favorites", 0, 0)
    object MealMenu: Screens("Meal Menu", 0, 0)

}
