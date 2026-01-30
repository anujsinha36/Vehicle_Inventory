package com.example.vehicleinventory.domain.util

import android.os.Build
import androidx.test.filters.SdkSuppress
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

@SdkSuppress(minSdkVersion = Build.VERSION_CODES.O)
class VehicleAgeHelperTest {

    @Test
    fun `calculate vehicle age`() {
        val currentYear = LocalDate.now().year
        val vehicleYear = currentYear - 5
        val expectedAge = "5 years ${LocalDate.now().monthValue + 6} months"
        assertEquals(expectedAge, getVehicleAge(vehicleYear))
    }
}