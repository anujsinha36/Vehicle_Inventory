package com.example.vehicleinventory.presentation.screens.addvehicle

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vehicleinventory.domain.util.VehicleData
import com.example.vehicleinventory.domain.util.getIconForOption
import com.example.vehicleinventory.presentation.designsystem.buttons.PrimaryButton
import com.example.vehicleinventory.presentation.designsystem.selections.SelectionSheet
import com.example.vehicleinventory.presentation.designsystem.textfields.DropdownTextField
import com.example.vehicleinventory.presentation.designsystem.textfields.InputTextField
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddVehicleScreen(
    onBackClick: () -> Unit = {},
    onAddVehicle: () -> Unit = {}
) {
    var showBrandSelection by remember { mutableStateOf(false) }
    var showModelSelection by remember { mutableStateOf(false) }
    var showFuelTypeSelection by remember { mutableStateOf(false) }
    var selectedBrand by remember { mutableStateOf("") }
    var selectedModel by remember { mutableStateOf("") }
    var selectedFuelType by remember { mutableStateOf("") }
    var vehicleNumber by remember { mutableStateOf("") }
    var selectedYear by remember { mutableStateOf("") }
    var ownerName by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Add Vehicle",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                )
            )
        },
        containerColor = Color.White
    ) { paddingValues ->
        if (showBrandSelection) {
            SelectionSheet(
                title = "Select Vehicle Brand",
                options = VehicleData.brands,
                selectedOption = selectedBrand,
                leadingIcon = { option ->
                    val iconRes = getIconForOption(option)
                    if (iconRes != null) {
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = option
                        )
                    }
                },
                onDismiss = { showBrandSelection = false },
                onOptionSelected = { brand ->
                    selectedBrand = brand
                    selectedModel = ""
                    showBrandSelection = false
                }
            )
        }
        if (showModelSelection) {
            SelectionSheet(
                title = "Select Vehicle Model",
                options = VehicleData.modelsByBrand[selectedBrand] ?: emptyList(),
                selectedOption = selectedModel,
                onDismiss = { showModelSelection = false },
                onOptionSelected = { model ->
                    selectedModel = model
                    showModelSelection = false
                }
            )
        }
        if (showFuelTypeSelection) {
            SelectionSheet(
                title = "Select Fuel Type",
                options = VehicleData.fuelTypes,
                selectedOption = selectedFuelType,
                onDismiss = { showFuelTypeSelection = false },
                onOptionSelected = { fuelType ->
                    selectedFuelType = fuelType
                    showFuelTypeSelection = false
                }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .padding(top = 16.dp)
            ) {
                SectionHeader(text = "VEHICLE DETAILS")

                Spacer(modifier = Modifier.height(16.dp))

                DropdownTextField(
                    label = "Brand",
                    placeholder = "Select a brand",
                    value = selectedBrand,
                    onClick = {
                        showBrandSelection = true
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                DropdownTextField(
                    label = "Model",
                    placeholder = "Select a model",
                    value = selectedModel,
                    onClick = {
                        if (selectedBrand.isNotEmpty() && selectedBrand != "Other") {
                            showModelSelection = true
                        }
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                DropdownTextField(
                    label = "Fuel Type",
                    placeholder = "Select fuel type",
                    value = selectedFuelType,
                    onClick = {
                    showFuelTypeSelection = true
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                InputTextField(
                    label = "Vehicle Number",
                    placeholder = "Enter vehicle number (e.g.MH 12 AB 1234)",
                    value = vehicleNumber,
                    onValueChange = { vehicleNumber = it }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                SectionHeader(text = "OTHER DETAILS")

                Spacer(modifier = Modifier.height(16.dp))

                InputTextField(
                    label = "Year of Purchase",
                    placeholder = "Select year of purchase",
                    value = selectedYear,
                    onValueChange = {selectedYear = it}
                )

                Spacer(modifier = Modifier.height(20.dp))

                InputTextField(
                    label = "Owner Name",
                    placeholder = "Enter owner's full name",
                    value = ownerName,
                    onValueChange = { ownerName = it }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Use your custom button component here
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp)
            ) {
                PrimaryButton(
                    text = "Add Vehicle",
                    onClick = onAddVehicle,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAddVehicleScreen(){
    VehicleInventoryTheme {
        AddVehicleScreen(

        )
    }
}