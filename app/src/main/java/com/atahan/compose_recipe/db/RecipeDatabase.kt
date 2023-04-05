package com.atahan.compose_recipe.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.atahan.compose_recipe.model.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class RecipeDatabase() : RoomDatabase() {
    abstract fun dao(): RecipeDao
}
