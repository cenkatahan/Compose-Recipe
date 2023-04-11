package com.atahan.compose_recipe.repository

import com.atahan.compose_recipe.db.RecipeDao
import com.atahan.compose_recipe.model.Recipe
import com.atahan.compose_recipe.util.Resource
import javax.inject.Inject

class RecipeRepo
@Inject constructor(
    private val dao: RecipeDao
) : IRepository {
    //TODO inject dao -> field injection.
    //TODO A Result class is needed. DONE
    override fun getRecipes(): Resource<List<Recipe>> {
        val recipes = try {
            dao.getRecipes()
        } catch (e: java.lang.Exception) {
            return Resource.Error("Recipes are not received.")
        }
        return Resource.Success(recipes)
    }

    override fun getRecipeBy(id: Int): Resource<Recipe> {
        val recipe = try {
            dao.getRecipeBy(id)
        } catch (e: Exception) {
            return Resource.Error("Recipe is not received.")
        }
        return Resource.Success(recipe)
    }

    //TODO there must be a return type for methods down below.
    override fun removeBy(recipe: Recipe) = dao.delete(recipe)
    override fun add(recipe: Recipe) = dao.insert(recipe)
    override fun update(recipe: Recipe) = dao.update(recipe)
}