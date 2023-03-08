package com.atahan.compose_recipe.model

import com.atahan.compose_recipe.R

sealed class Screen(val route: String, val icon: Int, val selectedIcon: Int) {

    object Home: Screen("Home", R.drawable.ic_home, R.drawable.ic_home_selected)
    object Favorites: Screen("Favorites", R.drawable.ic_favorite, R.drawable.ic_favorite_selected)
    object MealMenu: Screen("Meal Menu", R.drawable.ic_location, R.drawable.ic_location)

}
