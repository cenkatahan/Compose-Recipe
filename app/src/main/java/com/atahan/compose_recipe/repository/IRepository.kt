package com.atahan.compose_recipe.repository

import com.atahan.compose_recipe.model.Recipe
import com.atahan.compose_recipe.util.Resource

interface IRepository {
    fun getRecipes(): Resource<List<Recipe>>
    fun getRecipeBy(id: Int): Resource<Recipe>
    fun removeBy(recipe: Recipe)
    fun add(recipe: Recipe)
    fun update(recipe: Recipe)
}