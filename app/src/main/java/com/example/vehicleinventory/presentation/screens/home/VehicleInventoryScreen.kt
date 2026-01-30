package com.example.vehicleinventory.presentation.screens.home


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vehicleinventory.FilterScreen
import com.example.vehicleinventory.FilterOption
import com.example.vehicleinventory.FilterSection
import com.example.vehicleinventory.data.local.Vehicle
import com.example.vehicleinventory.domain.util.VehicleData
import com.example.vehicleinventory.presentation.viewmodels.VehicleViewModel
import com.example.vehicleinventory.presentation.designsystem.buttons.PrimaryButton
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

// Data classes
//data class Vehicle(
//    val modelAndBrand: String,
//    val vehicleNumber: String,
//    val fuelType: String,
//    val yearOfPurchase: String,
//    val duration: String
//)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun VehicleInventoryScreen(
    userName: String = "Amin",
//    vehicles: List<Vehicle>,
    onAddVehicleClick: () -> Unit = {},
    viewModel: VehicleViewModel = hiltViewModel()
) {


    val state = viewModel.uiState.collectAsState()
    val vehicles: List<Vehicle> = state.value.vehicles
    val systemUiController = rememberSystemUiController()

    DisposableEffect(systemUiController) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = false
        )
        onDispose {}
    }

    var showFilterDialog by remember { mutableStateOf(false) }

    var filterSections by remember {
        mutableStateOf(
            listOf(
                FilterSection("Brand", VehicleData.brands.map { FilterOption(it, false) }),
                FilterSection("Fuel Type", VehicleData.fuelTypes.map { FilterOption(it, false) })
            )
        )
    }

    val filteredVehicles = remember(vehicles, filterSections) {
        val selectedBrands = filterSections.find { it.title == "Brand" }
            ?.options?.filter { it.isSelected }?.map { it.label }?.toSet()
        val selectedFuelTypes = filterSections.find { it.title == "Fuel Type" }
            ?.options?.filter { it.isSelected }?.map { it.label }?.toSet()

        if (selectedBrands.isNullOrEmpty() && selectedFuelTypes.isNullOrEmpty()) {
            vehicles
        } else {
            vehicles.filter { vehicle ->
                val brand = vehicle.brand
                val fuelType = vehicle.fuelType

                val brandMatch = selectedBrands.isNullOrEmpty() || (brand != null && brand in selectedBrands)
                val fuelTypeMatch = selectedFuelTypes.isNullOrEmpty() || (fuelType in selectedFuelTypes)

                brandMatch && fuelTypeMatch
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        // Fixed Top Section
        TopSection(
            userName = userName,
            totalVehicles = state.value.totalVehicles,
            totalEV = state.value.totalEVs
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier.fillMaxSize()) {
            VehicleInventoryList(
                vehicles = filteredVehicles,
                onFilterClick = {showFilterDialog = true}
            )

                PrimaryButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(vertical = 30.dp, horizontal = 16.dp)
                        .height(52.dp),
                    text = "Add Vehicle",
                    onClick = onAddVehicleClick,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "TODO()"

                        )
                    }
                )
//            SecondaryButton(
//                text = "Delete data",
//                onClick = {viewModel.deleteAllVehicles()}
//            )


        }

    }
    if (showFilterDialog) {
        FilterScreen(
            filterSections = filterSections,
            onFilterChange = { sectionIndex, optionIndex, isSelected ->
                val newFilterSections = filterSections.toMutableList()
                val section = newFilterSections[sectionIndex]
                val newOptions = section.options.toMutableList()
                newOptions[optionIndex] = newOptions[optionIndex].copy(isSelected = isSelected)
                newFilterSections[sectionIndex] = section.copy(options = newOptions)
                filterSections = newFilterSections
            },
            onApply = {
                showFilterDialog = false
            },
            onClearAll = {
                filterSections = filterSections.map { section ->
                    section.copy(options = section.options.map { it.copy(isSelected = false) })
                }
            },
            onDismiss = { showFilterDialog = false }
        )
    }
}


@Preview
@Composable
fun PreviewInventoryScreen(){
    VehicleInventoryTheme {
//        VehicleInventoryScreen()
    }
}
