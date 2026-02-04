package com.sentinelai.app.ui.dashboard

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sentinelai.app.viewmodel.DashboardViewModel
import kotlinx.coroutines.flow.collectAsState
@Composable
fun DashboardScreen(
    dashboardViewModel: DashboardViewModel = viewModel()
) {
    val status by dashboardViewModel.statusText.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Sentinel AI Status",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(text = status)

        Button(onClick = { dashboardViewModel.simulateScan() }) {
            Text("Run Test Scan")
        }
    }
}
