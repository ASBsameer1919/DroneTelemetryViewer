package com.drone.telemetry.ui.connection

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConnectionScreen(
    onConnect: (String, Int) -> Unit
) {

    var ip by remember { mutableStateOf("") }
    var port by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Drone Connection",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = ip,
            onValueChange = { ip = it },
            label = { Text("IP Address") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = port,
            onValueChange = { port = it },
            label = { Text("Port") }
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {

                val portNumber =
                    if (port.isNotEmpty())
                        port.toInt()
                    else
                        14550

                onConnect(ip, portNumber)
            }
        ) {
            Text("Connect")
        }
    }
}