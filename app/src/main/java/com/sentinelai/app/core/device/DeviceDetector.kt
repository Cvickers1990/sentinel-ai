package com.sentinelai.app.core.device

import android.os.Build

object DeviceDetector {

    fun detect(): DeviceInfo {
        return DeviceInfo(
            manufacturer = Build.MANUFACTURER ?: "Unknown",
            model = Build.MODEL ?: "Unknown",
            androidVersion = Build.VERSION.RELEASE?.toIntOrNull() ?: -1,
            sdkInt = Build.VERSION.SDK_INT,
            isEmulator = isProbablyEmulator(),
            isDebuggable = Build.TAGS?.contains("debug") == true
        )
    }

    private fun isProbablyEmulator(): Boolean {
        return (
            Build.FINGERPRINT.contains("generic") ||
            Build.MODEL.contains("Emulator") ||
            Build.MODEL.contains("Android SDK")
        )
    }
}
