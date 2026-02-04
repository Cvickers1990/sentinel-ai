import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.sentinelai.app.ui.navigation.Screen
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
val currentScreen = remember { mutableStateOf<Screen>(Screen.Dashboard) }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(currentScreen.value.title) }
                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = currentScreen.value == Screen.Dashboard,
                        onClick = { currentScreen.value = Screen.Dashboard },
                        label = { Text("Dashboard") },
                        icon = {}
                    )
                    NavigationBarItem(
                        selected = currentScreen.value == Screen.Scan,
                        onClick = { currentScreen.value = Screen.Scan },
                        label = { Text("Scan") },
                        icon = {}
                    )
                    NavigationBarItem(
                        selected = currentScreen.value == Screen.Settings,
                        onClick = { currentScreen.value = Screen.Settings },
                        label = { Text("Settings") },
                        icon = {}
                    )
                }
            }
        ) { padding ->
            Surface(modifier = androidx.compose.ui.Modifier.padding(padding)) {
                when (currentScreen.value) {
                    Screen.Dashboard ->
                        com.sentinelai.app.ui.dashboard.DashboardScreen()
                    Screen.Scan ->
                        com.sentinelai.app.ui.scan.ScanScreen()
                    Screen.Settings ->
                        com.sentinelai.app.ui.settings.SettingsScreen()
                }
            }
        }
    }
}
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
