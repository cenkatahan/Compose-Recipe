package com.atahan.compose_recipe.view.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.atahan.compose_recipe.navigation.Graph
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.view.composables.ProfileTopBar

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            ProfileTopBar(
                onClickHome = { navController.navigate(Graph.APP_GRAPH) },
                onClickAdd = { navController.navigate(Screen.RecipeForm.route) }
            )
        }
    ) {
        Text(text = "Profile")
    }
}