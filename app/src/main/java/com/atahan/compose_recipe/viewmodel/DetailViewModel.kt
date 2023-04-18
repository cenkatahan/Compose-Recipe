package com.atahan.compose_recipe.viewmodel

import androidx.lifecycle.ViewModel
import com.atahan.compose_recipe.repository.RecipeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repo: RecipeRepo
) : ViewModel() {

    //TODO coroutines?
    fun getRecipe(id: Int) = repo.getRecipeBy(id)
}