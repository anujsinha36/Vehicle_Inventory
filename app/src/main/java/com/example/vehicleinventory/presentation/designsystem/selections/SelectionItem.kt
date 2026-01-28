package com.example.vehicleinventory.presentation.designsystem.selections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme

@Composable
fun SelectionItem(
    text: String,
    onCLick: () -> Unit,
    leadingIcon: (@Composable () -> Unit)? = null,
    isSelected: Boolean
){
    Surface(
        onClick = onCLick,
        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected){
                MaterialTheme.colorScheme.primary
            }
            else MaterialTheme.colorScheme.outlineVariant
        ),
        color = if (isSelected)
            MaterialTheme.colorScheme.primary.copy(0.05f)
        else
            Color.Transparent
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                leadingIcon?.invoke()

                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            RadioButton(
                selected = isSelected,
                onClick = null, // Click handled by Surface
                colors = RadioButtonDefaults.colors(
                        unselectedColor = MaterialTheme.colorScheme.outlineVariant
                        )
            )
        }
    }
}

@Preview
@Composable
fun PreviewSelectionItem(){
    VehicleInventoryTheme {
        SelectionItem(
            text = "TATA",
            onCLick = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "TODO()"
                )
            },
            isSelected = false
        )
    }
}