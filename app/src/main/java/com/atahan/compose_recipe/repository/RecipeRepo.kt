package com.atahan.compose_recipe.repository

import com.atahan.compose_recipe.db.RecipeDao
import com.atahan.compose_recipe.model.Recipe
import javax.inject.Inject

class RecipeRepo
@Inject constructor(
    private val dao: RecipeDao
) : IRepository {
    //TODO inject dao -> field injection.
    //TODO A Result class is needed.
    override fun getRecipes(): List<Recipe> = dao.getRecipes()
    override fun getRecipeBy(id: Int): Recipe = dao.getRecipeBy(id)
    override fun removeBy(recipe: Recipe) = dao.delete(recipe)
    override fun add(recipe: Recipe) = dao.insert(recipe)
    override fun update(recipe: Recipe) = dao.update(recipe)
}