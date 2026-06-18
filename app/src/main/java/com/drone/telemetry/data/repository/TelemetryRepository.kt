package com.drone.telemetry.data.repository

import com.drone.telemetry.data.model.TelemetryData
import com.drone.telemetry.data.network.SocketManager
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class TelemetryRepository {

    private val socketManager = SocketManager()

    private val _telemetry =
        MutableStateFlow(TelemetryData())

    val telemetry = _telemetry.asStateFlow()

    private val _connectionStatus =
        MutableStateFlow("Disconnected")

    val connectionStatus = _connectionStatus.asStateFlow()

    fun connect(port: Int) {

        if (socketManager.connect(port)) {

            _connectionStatus.value = "Connected"

            CoroutineScope(Dispatchers.IO).launch {

                while (true) {

                    _telemetry.value =
                        TelemetryData(
                            latitude = 12.9716,
                            longitude = 77.5946,
                            altitude = (100..120).random().toDouble(),
                            battery = (50..100).random(),
                            flightMode = "GUIDED",
                            armed = true
                        )

                    delay(1000)
                }
            }

        } else {

            _connectionStatus.value = "Connection Failed"
        }
    }
}