package com.atahan.compose_recipe.repository

import com.atahan.compose_recipe.model.Recipe

interface Repository {

    fun getRecipes(): List<RecipeRepo>
    fun getRecipeBy(id: Int): Recipe
    fun removeBy(id: Int)
    fun add(recipe: Recipe)
    fun update(recipe: Recipe)
}