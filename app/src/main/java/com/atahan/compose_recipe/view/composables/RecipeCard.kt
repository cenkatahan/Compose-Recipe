package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.model.Recipe
import com.atahan.compose_recipe.ui.theme.AppBlue

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecipeCard(
    recipe: Recipe,
    isFavorite: Boolean = false,
    isOnTheMenu: Boolean = false,
    onClickFavorite: ((Boolean) -> Unit)? = null,
    onClickToMenu: ((Boolean) -> Unit)? = null,
    onClickDetail: (() -> Unit)? = null
) {
    Card(
        elevation = 4.dp,
        border = BorderStroke(1.dp, AppBlue),
        modifier = Modifier.size(width = 150.dp, height = 150.dp),
        onClick = { onClickDetail?.let { it() } }
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            //Image and FavButton
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
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
                )


                IconButton(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(0.dp),
                    onClick = {
                        if (onClickFavorite != null) {
                            onClickFavorite(!isFavorite)
                        }
                    }
                ) {
                    when (isFavorite) {
                        true -> {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_favorite_selected),
                                contentDescription = "favorite_icon"
                            )
                        }
                        else -> {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_favorite),
                                contentDescription = "favorite_icon"
                            )
                        }
                    }

                }

                IconButton(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(0.dp),
                    onClick = {
                        if (onClickToMenu != null) {
                            onClickToMenu(!isOnTheMenu)
                        }
                    }
                ) {
                    when (isOnTheMenu) {
                        true -> {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_meal_plan_selected),
                                contentDescription = "favorite_icon"
                            )
                        }
                        else -> {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_meal_plan),
                                contentDescription = "favorite_icon"
                            )
                        }
                    }

                }
            }


            //Title and PrepTime(with watch icon)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = recipe.name,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.width(100.dp),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = recipe.prepareTime.toString(),
                    maxLines = 1,
                )
            }
        }
    }
    Spacer(modifier = Modifier.width(8.dp))
}