package com.sentinelai.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ScannedApp(
    val packageName: String,
    val risk: String
)

class ScanViewModel(application: Application) : AndroidViewModel(application) {

    private val _apps = MutableStateFlow<List<ScannedApp>>(emptyList())
    val apps: StateFlow<List<ScannedApp>> = _apps

    fun scanInstalledApps() {
        val pm = getApplication<Application>().packageManager
        val packages = pm.getInstalledApplications(0)

        _apps.value = packages.map {
            val risk = when {
                it.packageName.contains("system") -> "SYSTEM"
                it.packageName.contains("facebook") -> "CAUTION"
                else -> "SAFE"
            }
            ScannedApp(it.packageName, risk)
        }
    }
}
