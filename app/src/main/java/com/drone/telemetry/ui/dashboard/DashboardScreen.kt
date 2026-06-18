package com.drone.telemetry.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drone.telemetry.viewmodel.TelemetryViewModel

@Composable
fun DashboardScreen(
    viewModel: TelemetryViewModel
) {

    val data by viewModel.telemetry.collectAsState()
    val status by viewModel.connectionStatus.collectAsState()
    Text("Status : $status")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Drone Telemetry",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Latitude : ${data.latitude}")
        Text("Longitude : ${data.longitude}")
        Text("Altitude : ${data.altitude}")
        Text("Battery : ${data.battery}%")
        Text("Flight Mode : ${data.flightMode}")
        Text("Armed : ${data.armed}")
    }
}