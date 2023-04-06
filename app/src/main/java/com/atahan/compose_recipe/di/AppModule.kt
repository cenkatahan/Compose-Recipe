package com.atahan.compose_recipe.di

import android.content.Context
import androidx.room.Room
import com.atahan.compose_recipe.common.Common.TABLE_NAME
import com.atahan.compose_recipe.db.RecipeDao
import com.atahan.compose_recipe.db.RecipeDatabase
import com.atahan.compose_recipe.repository.IRepository
import com.atahan.compose_recipe.repository.RecipeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext applicationContext: Context) = Room
        .databaseBuilder(applicationContext, RecipeDatabase::class.java, TABLE_NAME)
        .allowMainThreadQueries()
        .build()

    @Singleton
    @Provides
    fun provideDao(db: RecipeDatabase) = db.dao()

    @Provides
    fun provideRepo(dao: RecipeDao) = RecipeRepo(dao) as IRepository
}