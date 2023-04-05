package com.atahan.compose_recipe.db

import androidx.room.*
import com.atahan.compose_recipe.common.Common.TABLE_NAME
import com.atahan.compose_recipe.model.Recipe

@Dao
interface RecipeDao {
    //TODO #1 implement coroutines
    //TODO #2 implement Result class and change each methods return type.

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipe: Recipe)

    @Update
    fun update(recipe: Recipe)

    @Delete
    fun delete(recipe: Recipe)

    @Query(value = "SELECT * FROM $TABLE_NAME")
    fun getRecipes(): List<Recipe>

    @Query("SELECT * FROM $TABLE_NAME WHERE id=:id")
    fun getRecipeBy(id: Int): Recipe
}
