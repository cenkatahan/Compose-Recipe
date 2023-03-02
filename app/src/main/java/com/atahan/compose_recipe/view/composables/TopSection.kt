package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R

@Composable
fun TopSection(modifier: Modifier) {

    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile_default),
                    contentDescription = "profile"
                )
            }

            Row (
                horizontalArrangement = Arrangement.Start
                    ){
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "location"
                )
                Text(text = "Izmir, Turkey")
            }


        }

        Text(
            text = "Let's find What you're gonna eat",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(top = 16.dp)
        )

    }

}