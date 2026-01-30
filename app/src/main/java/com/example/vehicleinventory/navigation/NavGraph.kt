package com.example.vehicleinventory.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vehicleinventory.presentation.screens.addvehicle.AddVehicleScreen
import com.example.vehicleinventory.presentation.screens.home.VehicleInventoryScreen

@Composable
fun NavGraph(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen
    ){
        composable<Screens.HomeScreen>{
            VehicleInventoryScreen(
                onAddVehicleClick = { navController.navigate(Screens.AddVehicleScreen)},
            )
        }
        composable<Screens.AddVehicleScreen>{
            AddVehicleScreen(
                onBackClick = {navController.popBackStack()},
                onAddVehicle = {navController.navigate(Screens.HomeScreen)}
            )
        }
    }
}