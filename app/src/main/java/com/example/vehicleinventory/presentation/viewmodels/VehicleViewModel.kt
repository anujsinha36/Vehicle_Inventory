package com.example.vehicleinventory.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vehicleinventory.data.local.Vehicle
import com.example.vehicleinventory.domain.usecase.AddVehicleUseCase
import com.example.vehicleinventory.domain.usecase.DeleteAllVehicleUseCase
import com.example.vehicleinventory.domain.usecase.GetElectricVehicleCountUseCase
import com.example.vehicleinventory.domain.usecase.GetTotalVehicleCountUseCase
import com.example.vehicleinventory.domain.usecase.GetVehiclesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(
    private val addVehicleUseCase: AddVehicleUseCase,
    getVehiclesUseCase: GetVehiclesUseCase,
    getTotalVehicleCountUseCase: GetTotalVehicleCountUseCase,
    getElectricVehicleCountUseCase: GetElectricVehicleCountUseCase,
    private val deleteAllVehicleUseCase: DeleteAllVehicleUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(VehicleInventoryState())
    val uiState = _uiState.asStateFlow()

    init {
        // 3. Combine the flows from the use cases
        viewModelScope.launch {
            combine(
                getVehiclesUseCase(),
                getTotalVehicleCountUseCase(),
                getElectricVehicleCountUseCase()
            ) { vehicles, totalCount, evCount ->
                // 4. Create a new state object with the latest data
                VehicleInventoryState(
                    vehicles = vehicles,
                    totalVehicles = totalCount,
                    totalEVs = evCount,
                    isLoading = false
                )
            }.collect { newState ->
                Log.d("VehicleViewModel", "Received state: total=${newState.totalVehicles}, ev=${newState.totalEVs}, vehiclesListSize=${newState.vehicles.size}")
                _uiState.value = newState
            }
        }
    }

    fun addVehicle(vehicle: Vehicle){
        viewModelScope.launch {
            Log.d("VehicleViewModel", "Adding vehicle: $vehicle")
            addVehicleUseCase(vehicle)
        }
    }

    fun deleteAllVehicles() {
        viewModelScope.launch {
            Log.d("VehicleViewModel", "Deleting all vehicles")
            deleteAllVehicleUseCase()
        }
    }

}

data class VehicleInventoryState(
    val vehicles: List<Vehicle> = emptyList(),
    val totalVehicles: Int = 0,
    val totalEVs: Int =0,
    val isLoading: Boolean = true // You can add other states like this
)