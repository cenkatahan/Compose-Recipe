package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.common.Mock
import com.atahan.compose_recipe.ui.theme.AppGrey
import com.atahan.compose_recipe.view.composables.OutlinedChip


@Composable
fun RecipeDetailScreen(recipeId: Int, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val recipe = Mock.fetchMockMeals().first { it.id == recipeId }
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                end = 16.dp,
            )
            .verticalScroll(scrollState)
    ) {

        //TITLE
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(8.dp))
        //BIG IMAGE
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    //TODO color for temporary background 0xFFFC5B5B
                    .background(
                        color = Color(0xB0FC5B5B),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {

                //FAV BUTTON
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .shadow(4.dp, RoundedCornerShape(24.dp))
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color.White)
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = "favorite button"
                    )
                }

                //MEAL BUTTON
//                IconButton(
//                    onClick = { },
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(24.dp))
//                        .background(Color.White)
//                        .align(Alignment.TopEnd)
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_meal_plan),
//                        contentDescription = "favorite button"
//                    )
//                }
            }
        }


        //INGREDIENT CHIPS
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
        }

        //DESCRIPTION
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = recipe.description,
            modifier = Modifier.fillMaxWidth()
        )
    }

}