package com.example.vehicleinventory.domain.util

object VehicleData {

        val brands = listOf("Tata", "Honda", "Yamaha", "Hero", "Bajaj", "Other")

        val modelsByBrand = mapOf(
            "Tata" to listOf("Nexon", "Punch", "Tiago", "Harrier", "Safari"),
            "Honda" to listOf("Activa 4G", "Activa 5G", "Activa 6G", "Activa 125", "Activa 125 BS6", "Active H-Smart"),
            "Yamaha" to listOf("FZ", "MT-15", "R15", "RayZR", "Fascino"),
            "Hero" to listOf("XPulse", "Karizma", "Passion", "Optima", "Splendor"),
            "Bajaj" to listOf("Pulsar", "Avenger", "Platina", "Chetak", "NS160")
        )

        val fuelTypes = listOf("Petrol", "Electric", "Diesel", "CNG")

}