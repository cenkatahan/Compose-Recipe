package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.model.Meal
import com.atahan.compose_recipe.model.MealType

@Composable
fun MealCard(meal: Meal) {
    Card(
        elevation = 4.dp,
        backgroundColor = Color(0xFFD8D8D8)
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(8.dp)
        ) {
            //Image and FavButton
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                    Image(painter =, contentDescription =)
                Text(text = "A PIC. TEMP")
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = "favorite_icon"
                    )
                }
            }


            //Title and PrepTime(with watch icon)
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = meal.name, fontWeight = FontWeight.Bold)
                Text(text = meal.prepareTime.toString())
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