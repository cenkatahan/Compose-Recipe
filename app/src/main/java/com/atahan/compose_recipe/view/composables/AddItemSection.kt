package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.ui.theme.AppBlue
import com.atahan.compose_recipe.view.screen.ParameterType
import com.atahan.compose_recipe.viewmodel.FormViewModel

@Composable
fun AddItemSection(
    section: SnapshotStateList<String>,
    toggleDialog: (Boolean) -> Unit,
    onClickDelete: (Int) -> Unit,
    viewModel: FormViewModel = hiltViewModel()
) {
    Column {
        Button(
            onClick = {
                //TODO open dialog
                toggleDialog(true)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add_circle),
                contentDescription = "add new description",
            )
        }

        section.forEachIndexed { index, step ->
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dot),
                        contentDescription = "dot",
                        tint = AppBlue
                    )
                    Text(
                        text = step,
                    )
                }
                IconButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = {
                        //TODO openDialog and edit
                        onClickDelete(index)
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = "delete",
                    )
                }
            }
        }
    }
}