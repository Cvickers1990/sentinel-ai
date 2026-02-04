package com.sentinelai.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SentinelApp()
        }
    }
}

@Composable
fun SentinelApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sentinel AI") }
            )
        }
    ) { padding ->
        Surface(modifier = androidx.compose.ui.Modifier.padding(padding)) {
        com.sentinelai.app.ui.dashboard.DashboardScreen()
}
