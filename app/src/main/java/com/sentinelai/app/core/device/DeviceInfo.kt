package com.sentinelai.app.core.device

data class DeviceInfo(
    val manufacturer: String,
    val model: String,
    val androidVersion: Int,
    val sdkInt: Int,
    val isEmulator: Boolean,
    val isDebuggable: Boolean
)
