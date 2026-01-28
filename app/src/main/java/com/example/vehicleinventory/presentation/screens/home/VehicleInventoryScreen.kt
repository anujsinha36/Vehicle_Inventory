package com.example.vehicleinventory.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vehicleinventory.presentation.VehicleViewModel
import com.example.vehicleinventory.presentation.designsystem.buttons.PrimaryButton
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme

// Data classes
data class Vehicle(
    val modelAndBrand: String,
    val vehicleNumber: String,
    val fuelType: String,
    val yearOfPurchase: String,
    val duration: String
)

@Composable
fun VehicleInventoryScreen(
    userName: String = "Amin",
    modifier: Modifier,
    totalVehicles: Int = 2300,
    totalEV: Int = 2300,
    vehicles: List<Vehicle> = getSampleVehicles(),
    onAddVehicleClick: () -> Unit = {},
    onFilterClick: () -> Unit = {},
  //  viewModel: VehicleViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        // Fixed Top Section
        TopSection(
            userName = userName,
            totalVehicles = totalVehicles,
            totalEV = totalEV
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier.fillMaxSize()) {
            VehicleInventoryList(
                vehicles = vehicles,
                onFilterClick = onFilterClick
            )
            PrimaryButton(
                modifier = Modifier.align(Alignment.BottomEnd)
                    .padding(vertical = 22.dp, horizontal = 3.dp),
                text = "Add Vehicle",
                onClick = onAddVehicleClick,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "TODO()"

                    )
                }
            )
        }
        // Scrollable Bottom Section


    }
}

// Sample data function
fun getSampleVehicles(): List<Vehicle> {
    return listOf(
        Vehicle(
            modelAndBrand = "Activa 4G\nHonda",
            vehicleNumber = "KA 01 AA 0027",
            fuelType = "Petrol",
            yearOfPurchase = "2018",
            duration = "7 years 0 months"
        ),
        Vehicle(
            modelAndBrand = "Nexon XM\nTata",
            vehicleNumber = "KA 10 AM 2523",
            fuelType = "Petrol",
            yearOfPurchase = "2021",
            duration = "5 years 1 month"
        ),
        Vehicle(
            modelAndBrand = "Activa 125\nHonda",
            vehicleNumber = "DL 8 CAF 9876",
            fuelType = "Petrol",
            yearOfPurchase = "2020",
            duration = "5 years 4 months"
        ),
        Vehicle(
            modelAndBrand = "Activa 125\nHonda",
            vehicleNumber = "DL 8 CAF 9876",
            fuelType = "Petrol",
            yearOfPurchase = "2020",
            duration = "4 years 3 months"
        ),
        Vehicle(
            modelAndBrand = "City VX\nHonda",
            vehicleNumber = "TN 22 CZ 3344",
            fuelType = "Petrol",
            yearOfPurchase = "2022",
            duration = "3 years 2 months"
        ),
        Vehicle(
            modelAndBrand = "Pulsar 150\nBajaj",
            vehicleNumber = "UP 32 KT 1098",
            fuelType = "Petrol",
            yearOfPurchase = "2019",
            duration = "6 years 5 months"
        )
    )
}

@Preview
@Composable
fun PreviewInventoryScreen(){
    VehicleInventoryTheme {
        VehicleInventoryScreen(modifier = Modifier)
    }
}
