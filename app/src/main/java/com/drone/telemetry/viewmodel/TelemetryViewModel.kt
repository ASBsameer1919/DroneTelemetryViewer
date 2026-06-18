package com.drone.telemetry.viewmodel

import androidx.lifecycle.ViewModel
import com.drone.telemetry.data.repository.TelemetryRepository

class TelemetryViewModel : ViewModel() {

    private val repository = TelemetryRepository()

    val telemetry = repository.telemetry

    val connectionStatus = repository.connectionStatus

    fun connect(port: Int) {
        repository.connect(port)
    }
}