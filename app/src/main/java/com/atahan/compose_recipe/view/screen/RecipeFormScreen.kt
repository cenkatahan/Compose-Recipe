package com.atahan.compose_recipe.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.navigation.Graph
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.view.composables.FormTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "MutableCollectionMutableState")
@Composable
fun RecipeFormScreen(
    navController: NavHostController
) {

    Scaffold(
        topBar = {
            FormTopBar(
                onClickHome = { navController.navigate(Graph.APP_GRAPH) },
                onClickConfirmAdd = {
                    //TODO implement code here.
                    navController.navigate(Graph.APP_GRAPH) {
                        popUpTo(Screen.Home.route)
                    }
                }
            )
        }
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = "Add a Recipe",
                style = MaterialTheme.typography.h2,
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Recipe Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Column {

                var descriptions by remember {
                    mutableStateOf(1)
                }

                (0 until descriptions).forEach {
                    Spacer(modifier = Modifier.height(4.dp))
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text(text = "Recipe Description") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Button(
                    onClick = {
                        descriptions++
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add_circle),
                        contentDescription = "add new description",
                    )
                }
            }
        }

    }
}