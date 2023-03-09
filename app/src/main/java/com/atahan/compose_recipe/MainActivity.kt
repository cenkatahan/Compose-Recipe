package com.atahan.compose_recipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.atahan.compose_recipe.navigation.AppNavigation
import com.atahan.compose_recipe.ui.theme.ComposeRecipeTheme
import com.atahan.compose_recipe.view.composables.BottomSection
import com.atahan.compose_recipe.view.composables.TopSection

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRecipeTheme {
                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = { TopSection(modifier = Modifier.padding(16.dp)) },
                    bottomBar = { BottomSection(navController = navController, onItemClick = {
                        navController.navigate(it.route) {
                            popUpTo(it.route){
                                inclusive = true
                            }
                        }
                    }) },
                    modifier = Modifier.fillMaxSize(),
                ){
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeRecipeTheme {

    }
}