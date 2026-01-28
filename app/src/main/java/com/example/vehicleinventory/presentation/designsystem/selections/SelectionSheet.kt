package com.example.vehicleinventory.presentation.designsystem.selections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.vehicleinventory.domain.util.getIconForOption
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme

@Composable
fun SelectionSheet(
    title: String,
    options: List<String>,
    selectedOption: String?,
    leadingIcon: (@Composable (String) -> Unit)? = null,
    onOptionSelected: (String) -> Unit,
    onDismiss: () -> Unit
){
    Dialog(onDismissRequest = onDismiss
    ) { Surface( modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onTertiary
                )
                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close"
                    )
                }
            }
            Divider()

            Spacer(modifier = Modifier.padding(vertical = 12.dp))

            LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                items(options){option->
                    SelectionItem(
                        text = option,
                        onCLick = {
                            onOptionSelected(option)
                        },
                        leadingIcon = { leadingIcon?.invoke(option) },
                        isSelected = option == selectedOption,
                    )
                }
            }
        }
    }
    }
}

@Preview
@Composable
fun PreviewSelectionSheet(){
    VehicleInventoryTheme {
        SelectionSheet(
            title = "Select Vehicle Brand",
            options = listOf("Tata", "Honda", "Yamaha"),
            selectedOption = "Tata",
           leadingIcon = { option->
               val iconRes = getIconForOption(option)
               if (iconRes != null){
                   Icon(
                       painter = painterResource(id = iconRes),
                       contentDescription = option
                   )
               }
           },
            onDismiss = {},
            onOptionSelected = {}
        )
    }
}