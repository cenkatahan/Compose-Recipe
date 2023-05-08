package com.atahan.compose_recipe.navigation

import com.atahan.compose_recipe.R

sealed class Screen(val route: String, val icon: Int? = null, val selectedIcon: Int? = null) {

    object Home : Screen("Home", R.drawable.ic_home, R.drawable.ic_home_selected)
    object Favorites : Screen("Favorites", R.drawable.ic_favorite, R.drawable.ic_favorite_selected)
    object MealMenu : Screen("Menu", R.drawable.ic_meal_plan, R.drawable.ic_meal_plan_selected)
    object Profile : Screen("Profile")
    object RecipeForm : Screen("Add Recipe")
    object RecipeDetail : Screen("Recipe Detail")
    object Search : Screen("Search")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }

}
