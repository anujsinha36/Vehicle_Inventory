package com.example.vehicleinventory.domain.usecase

import com.example.vehicleinventory.domain.Repository.VehicleRepository
import javax.inject.Inject

class GetVehiclesUseCase @Inject constructor(private val repository: VehicleRepository ) {

    operator fun invoke() = repository.getVehicles()
}