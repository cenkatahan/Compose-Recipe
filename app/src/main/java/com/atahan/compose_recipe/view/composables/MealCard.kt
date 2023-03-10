package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.model.Meal
import com.atahan.compose_recipe.model.MealType
import com.atahan.compose_recipe.ui.theme.AppBlue

@Composable
fun MealCard(meal: Meal) {
    Card(
        elevation = 4.dp,
        border = BorderStroke(1.dp, AppBlue),
        modifier = Modifier.size(width = 150.dp, height = 150.dp)

//        backgroundColor = Color(0xFFD8D8D8)
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
                    onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = "favorite_icon"
                    )
                }
            }


            //Title and PrepTime(with watch icon)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = meal.name,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.width(100.dp),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = meal.prepareTime.toString(),
                    maxLines = 1,
                )
            }
        }
    }
    Spacer(modifier = Modifier.width(8.dp))
}


@Preview(showBackground = true)
@Composable
fun MealCardPreview() {
    val meal = Meal(
        name = "Lazanya",
        description = "HJHJHJHJHJHJH",
        isFavorite = false,
        type = MealType.FAST_FOOD,
        prepareTime = 45
    )
    MealCard(meal)
}