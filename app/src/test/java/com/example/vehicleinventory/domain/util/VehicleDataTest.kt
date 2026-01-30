package com.example.vehicleinventory.domain.util

import org.junit.Assert.assertTrue
import org.junit.Test

class VehicleDataTest {

    @Test
    fun `brands list is not empty`() {
        assertTrue(VehicleData.brands.isNotEmpty())
    }

    @Test
    fun `modelsByBrand map is not empty`() {
        assertTrue(VehicleData.modelsByBrand.isNotEmpty())
    }

    @Test
    fun `fuelTypes list is not empty`() {
        assertTrue(VehicleData.fuelTypes.isNotEmpty())
    }
}