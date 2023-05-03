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
class MenuViewModel @Inject constructor(
    private val repo: RecipeRepo
) : ViewModel() {

    var recipesOnMenu = mutableStateOf<List<Recipe>>(listOf())
    var isLoading = mutableStateOf(false)
    var error = mutableStateOf("")

    init {
        loadRecipesOnMenu()
    }

    fun loadRecipesOnMenu() {
        viewModelScope.launch {
            val result = repo.getRecipes()
            when (repo.getRecipes()) {
                is Resource.Success -> {
                    recipesOnMenu.value = result.data?.filter { it.isOnTheMealMenu } ?: listOf()
                    isLoading.value = false
                }

                is Resource.Error -> {
                    error.value = result.message.toString()
                    isLoading.value = false
                }

                else -> isLoading.value = true
            }

        }
    }

    fun updateRecipe(recipe: Recipe) {
        viewModelScope.launch {
            val result = repo.update(recipe)

            when (repo.update(recipe)) {
                is Resource.Success -> {
                    repo.update(recipe)
                    isLoading.value = false
                }
                is Resource.Error -> {
                    error.value = result.message.toString()
                }
                else -> isLoading.value = true
            }
        }
    }
}