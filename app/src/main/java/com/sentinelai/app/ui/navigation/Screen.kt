package com.sentinelai.app.ui.navigation

sealed class Screen(val title: String) {
    object Dashboard : Screen("Dashboard")
    object Scan : Screen("Scan")
    object Settings : Screen("Settings")
}
