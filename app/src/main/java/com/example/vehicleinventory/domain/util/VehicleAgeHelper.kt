package com.example.vehicleinventory.domain.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun getVehicleAge(year: Int): String {
    val now = LocalDate.now()
    val years = now.year - year
    val months = now.monthValue + 6
    return "$years years $months months"
}
