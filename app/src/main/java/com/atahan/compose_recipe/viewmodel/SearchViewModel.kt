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
class SearchViewModel @Inject constructor(
    private val repo: RecipeRepo
) : ViewModel() {
    var recipes = mutableStateOf<List<Recipe>>(listOf())
    var isLoading = mutableStateOf(false)
    var error = mutableStateOf("")
    val allRecipes = mutableStateOf<List<Recipe>>(listOf())

    init {
        loadAllRecipes()
    }

    fun loadAllRecipes() {
        viewModelScope.launch {
            isLoading.value = true

            val result = repo.getRecipes()
            when (repo.getRecipes()) {
                is Resource.Success -> {
                    result.data?.let { recipes.value = it }
                    result.data?.let { allRecipes.value = it }
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



    fun search(query: String) {
        viewModelScope.launch {
            isLoading.value = true
            recipes.value = allRecipes.value.filter {
                it.name.lowercase().contains(query.lowercase())
            }

            val isFoundAny = recipes.value.any {
                it.name.lowercase().contains(query.lowercase())
            }

            if (!isFoundAny) {
                isLoading.value = false
                error.value = "No such a recipe."
            }

            if (recipes.value.isEmpty()) {
                isLoading.value = false
                error.value = ""
            }

            error.value = ""
            isLoading.value = false
        }
    }
}