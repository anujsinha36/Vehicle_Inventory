package com.example.vehicleinventory.navigation

import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable
    object HomeScreen

    @Serializable
    object AddVehicleScreen
}