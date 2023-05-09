package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.navigation.Graph
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.ui.theme.AppBlue
import com.atahan.compose_recipe.ui.theme.AppGrey

@Composable
fun SearchButton(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    OutlinedButton(
        modifier = modifier,
        border = BorderStroke(0.5.dp, AppBlue),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = AppGrey
        ),
        onClick = {
            navController.navigate(Graph.SEARCH_GRAPH) {
                popUpTo(Screen.Home.route)
            }
        },
        content = {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search icon",
                    tint = AppBlue,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Search...",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    letterSpacing = 0.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
        }
    )
}