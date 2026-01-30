package com.example.vehicleinventory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.vehicleinventory.presentation.designsystem.buttons.PrimaryButton
import com.example.vehicleinventory.presentation.designsystem.buttons.SecondaryButton
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme
import kotlin.collections.forEachIndexed

data class FilterOption(
    val label: String,
    val isSelected: Boolean
)

data class FilterSection(
    val title: String,
    val options: List<FilterOption>
)

@Composable
fun FilterScreen(
    filterSections: List<FilterSection>,
    onFilterChange: (sectionIndex: Int, optionIndex: Int, isSelected: Boolean) -> Unit,
    onApply: () -> Unit,
    onClearAll: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    // State to keep track of the selected filter section index
    var selectedSectionIndex by remember { mutableStateOf(0) }

    Dialog(onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                // Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Filter",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Divider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.4f))

                Row(
                    modifier = Modifier

                ) {
                    // Column for filter section titles (Brand, Fuel Type)
                    Column(
                        modifier = Modifier
                            .weight(0.4f)
                            .verticalScroll(rememberScrollState())
                            .background(MaterialTheme.colorScheme.surface)

                    ) {
                        filterSections.forEachIndexed { index, section ->
                            Text(
                                text = section.title,
                                style = if (selectedSectionIndex == index) MaterialTheme.typography.bodyMedium else MaterialTheme.typography.bodySmall,
                                color = if (selectedSectionIndex == index) Color(0xFF007AFF) else Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { selectedSectionIndex = index }
                                    .padding(16.dp)
                            )
                            if (index < filterSections.size - 1) {
                                Divider(
                                    modifier = Modifier.padding(start = 15.dp),
                                    color = Color.LightGray.copy(alpha = 0.3f)
                                )
                            }
                        }
                    }

                    // Column for the options of the selected filter section
                    Column(
                        modifier = Modifier
                            .weight(0.6f)
                            .verticalScroll(rememberScrollState())
                            .background(MaterialTheme.colorScheme.surfaceContainer.copy(alpha = 0.5f))
                            .padding(horizontal = 16.dp)
                    ) {
                        val selectedSection = filterSections[selectedSectionIndex]

                        Spacer(modifier = Modifier.height(16.dp))

                        selectedSection.options.forEachIndexed { optionIndex, option ->
                            FilterOptionRow(
                                label = option.label,
                                isSelected = option.isSelected,
                                onCheckedChange = { isChecked ->
                                    onFilterChange(selectedSectionIndex, optionIndex, isChecked)
                                }
                            )

                            if (optionIndex < selectedSection.options.size - 1) {
                                Divider(
                                    modifier = Modifier.padding(vertical = 12.dp),
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }


                // Bottom buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    SecondaryButton(
                        text = "Clear All",
                        onClick = onClearAll,
                        modifier = Modifier.weight(1f)
                    )

                    PrimaryButton(
                        text = "Apply",
                        onClick = onApply,
                        modifier = Modifier.weight(1f),
                        leadingIcon = null
                    )
                }
            }
        }
    }
}

@Composable
fun FilterOptionRow(
    label: String,
    isSelected: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable{onCheckedChange(!isSelected)}
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        CustomCheckbox(isSelected)
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview() {
    // Add more options to demonstrate scrolling
    val filterSections = listOf(
        FilterSection(
            title = "Brand",
            options = listOf(
                FilterOption("Tata", false),
                FilterOption("Honda", true),
                FilterOption("Hero", false),
                FilterOption("Bajaj", true),
                FilterOption("Yamaha", false),
                FilterOption("Other", false)
            )
        ),
        FilterSection(
            title = "Fuel Type",
            options = listOf(
                FilterOption("Petrol", true),
                FilterOption("Diesel", false),
                FilterOption("Electric", true),
                FilterOption("CNG", false)
            )
        )
    )
    VehicleInventoryTheme {
        FilterScreen(
            filterSections = filterSections,
            onFilterChange = { _, _, _ -> },
            onApply = {},
            onClearAll = {},
            onDismiss = {}
        )
    }
}
