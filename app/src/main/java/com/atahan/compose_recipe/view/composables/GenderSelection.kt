package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenderSelection(
    selectedGender: MutableState<Gender>,
) {
    val genders = Gender.values().filter { it.isOnDisplay }

    Row {
        LazyRow(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        ) {
            genders.forEach { gender ->
                item {
                    GenderButton(
                        gender = gender,
                        selectedGender = selectedGender.value,
                        onCLickGender = {
                            selectedGender.value = it
                        }
                    )
                }
            }
        }
    }
}