package com.atahan.compose_recipe.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.atahan.compose_recipe.model.Recipe

@Database(entities = [Recipe::class], version = 2)
@TypeConverters(value = [Converters::class])
abstract class RecipeDatabase() : RoomDatabase() {
    abstract fun dao(): RecipeDao
}
