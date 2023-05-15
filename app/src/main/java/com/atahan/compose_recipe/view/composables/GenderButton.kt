package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.ui.theme.AppBlue

@Composable
fun GenderButton(
    gender: Gender,
    selectedGender: Gender,
    onCLickGender: ((Gender) -> Unit) = {}
) {
    val isSelected = gender == selectedGender
    val textColor = when (isSelected) {
        true -> Color.White
        else -> AppBlue
    }
    val background = when (isSelected) {
        true -> AppBlue
        else -> Color.White
    }

    val icon = when (gender) {
        Gender.FEMALE -> painterResource(id = R.drawable.ic_female)
        else -> painterResource(id = R.drawable.ic_male)
    }

    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(background)
            .clickable {
                onCLickGender(gender)
            },
        contentAlignment = Alignment.Center
    ) {

        Icon(
            painter = icon,
            contentDescription = "profile",
            tint = textColor,
            modifier = Modifier.size(48.dp)
        )

    }
}

enum class Gender(val isOnDisplay: Boolean) {
    FEMALE(true),
    MALE(true),
    IDLE(false)
}