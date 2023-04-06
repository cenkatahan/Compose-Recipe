package com.atahan.compose_recipe.repository

import com.atahan.compose_recipe.model.Recipe

interface IRepository {
    fun getRecipes(): List<Recipe>
    fun getRecipeBy(id: Int): Recipe
    fun removeBy(recipe: Recipe)
    fun add(recipe: Recipe)
    fun update(recipe: Recipe)
}