package com.sentinelai.app.ui.dashboard

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "System Overview",
            style = MaterialTheme.typography.headlineMedium
        )

        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Device Status")
                Text("No device connected")
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Security Scan")
                Text("Scan not started")
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Actions")
                Text("Debloat • Scan • Connect")
            }
        }
    }
}
