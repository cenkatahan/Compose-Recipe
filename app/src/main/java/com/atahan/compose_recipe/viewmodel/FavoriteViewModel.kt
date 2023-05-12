package com.atahan.compose_recipe.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atahan.compose_recipe.model.Recipe
import com.atahan.compose_recipe.repository.RecipeRepo
import com.atahan.compose_recipe.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repo: RecipeRepo
) : ViewModel() {
    var favRecipes = mutableStateOf<List<Recipe>>(listOf())
    var isLoading = mutableStateOf(false)
    var error = mutableStateOf("")

    init {
        loadFavoriteRecipes()
    }

    fun loadFavoriteRecipes() {
        viewModelScope.launch {
            isLoading.value = true

            val result = repo.getRecipes()
            when (repo.getRecipes()) {
                is Resource.Success -> {
                    favRecipes.value = result.data?.filter { it.isFavorite }!!
                    isLoading.value = false
                }
                is Resource.Error -> {
                    isLoading.value = false
                    result.message?.let { error.value = it }
                }
                else -> isLoading.value = true
            }
        }
    }

    fun updateRecipe(recipe: Recipe) {
        viewModelScope.launch {
            isLoading.value = true
            val result = repo.update(recipe)

            when (repo.update(recipe)) {
                is Resource.Success -> {
                    repo.update(recipe)
                    isLoading.value = false
                    loadFavoriteRecipes()
                }
                is Resource.Error -> {
                    isLoading.value = false
                    result.message?.let {
                        error.value = it
                    }
                }
                else -> isLoading.value = true
            }
        }
    }
}