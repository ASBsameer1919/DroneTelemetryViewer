package com.drone.telemetry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.drone.telemetry.ui.connection.ConnectionScreen
import com.drone.telemetry.ui.dashboard.DashboardScreen
import com.drone.telemetry.viewmodel.TelemetryViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var connected by remember {
                mutableStateOf(false)
            }

            val viewModel = remember {
                TelemetryViewModel()
            }

            if (connected) {

                DashboardScreen(viewModel)

            } else {

                ConnectionScreen { ip, port ->

                    viewModel.connect(port)

                    connected = true
                }
            }
        }
    }
}