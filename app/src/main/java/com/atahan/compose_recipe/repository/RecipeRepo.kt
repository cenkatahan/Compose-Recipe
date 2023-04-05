package com.atahan.compose_recipe.repository

import com.atahan.compose_recipe.model.Recipe

class RecipeRepo: Repository {
    //TODO inject dao -> field injection.

    override fun getRecipes(): List<RecipeRepo> {
        TODO("Not yet implemented")
    }

    override fun getRecipeBy(id: Int): Recipe {
        TODO("Not yet implemented")
    }

    override fun removeBy(id: Int) {
        TODO("Not yet implemented")
    }

    override fun add(recipe: Recipe) {
        TODO("Not yet implemented")
    }

    override fun update(recipe: Recipe) {
        TODO("Not yet implemented")
    }
}