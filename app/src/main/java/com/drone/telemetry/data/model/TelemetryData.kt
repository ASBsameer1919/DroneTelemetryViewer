package com.drone.telemetry.data.model

data class TelemetryData(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val altitude: Double = 0.0,
    val battery: Int = 0,
    val flightMode: String = "UNKNOWN",
    val armed: Boolean = false
)