package com.atahan.compose_recipe.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atahan.compose_recipe.common.Mock
import com.atahan.compose_recipe.model.Recipe
import com.atahan.compose_recipe.repository.RecipeRepo
import com.atahan.compose_recipe.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: RecipeRepo
) : ViewModel() {

    var recipes = mutableStateOf<List<Recipe>>(listOf())
    var isLoading = mutableStateOf(false)
    var error = mutableStateOf("")

    init {
        if (repo.checkDbEmpty()) {
            Mock.fetchMockMeals().forEach { repo.add(it) }
        }
        loadRecipes()
    }

    fun loadRecipes() {
        viewModelScope.launch {
            isLoading.value = true

            val result = repo.getRecipes()
            when (repo.getRecipes()) {
                is Resource.Success -> {
                    result.data?.let { recipes.value = it }
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

}