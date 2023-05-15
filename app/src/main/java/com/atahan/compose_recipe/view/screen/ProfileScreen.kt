package com.atahan.compose_recipe.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.navigation.Graph
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.ui.theme.AppBlue
import com.atahan.compose_recipe.view.composables.Gender
import com.atahan.compose_recipe.view.composables.GenderSelection
import com.atahan.compose_recipe.view.composables.ProfileTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            ProfileTopBar(
                onClickHome = {
                    navController.navigate(Graph.APP_GRAPH) {
                        popUpTo(Screen.Home.route)
                    }
                },
                onClickAdd = {
                    navController.navigate(Screen.RecipeForm.route) {
                        popUpTo(Screen.Home.route)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val selectedGender = remember { mutableStateOf(Gender.IDLE) }

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile_default),
                        contentDescription = "profile",
                        tint = AppBlue,
                        modifier = Modifier
                            .size(200.dp)
                            .align(Alignment.Center)
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Neriman",
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = AppBlue
            )

            Spacer(modifier = Modifier.height(16.dp))
            GenderSelection(selectedGender = selectedGender)
        }
    }
}