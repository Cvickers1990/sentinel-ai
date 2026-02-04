package com.sentinelai.app.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DashboardViewModel : ViewModel() {

    private val _statusText = MutableStateFlow("System idle")
    val statusText: StateFlow<String> = _statusText

    fun simulateScan() {
        _statusText.value = "Scanning device…"
    }
}
