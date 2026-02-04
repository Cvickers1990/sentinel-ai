package com.sentinelai.app.ui.scan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sentinelai.app.viewmodel.ScanViewModel

@Composable
fun ScanScreen(
    scanViewModel: ScanViewModel = viewModel()
) {
    val apps by scanViewModel.apps.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Button(
            onClick = { scanViewModel.scanInstalledApps() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Run Scan")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(apps) { app ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(app.packageName, style = MaterialTheme.typography.bodyMedium)
                        Text("Risk: ${app.risk}")
                    }
                }
            }
        }
    }
}
