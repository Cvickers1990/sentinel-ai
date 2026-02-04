package com.sentinelai.app.viewmodel

import androidx.lifecycle.ViewModel
import com.sentinelai.app.core.device.DeviceDetector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DashboardViewModel : ViewModel() {

    private val _statusText = MutableStateFlow("Initializing…")
    val statusText: StateFlow<String> = _statusText

    init {
        val device = DeviceDetector.detect()
        _statusText.value =
            "Device: ${device.manufacturer} ${device.model}\n" +
            "Android SDK: ${device.sdkInt}\n" +
            "Emulator: ${device.isEmulator}"
    }

    fun simulateScan() {
        _statusText.value = "Scan requested (simulation only)"
    }
}
