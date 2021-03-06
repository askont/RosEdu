package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings.state

import ru.leadersofdigital.rosedu.models.model.SubDevice

data class NetworkSettingsState(
    val device: SubDevice?,
    val iedDevices: List<SubDevice>?
) {
    companion object {
        fun initial() = NetworkSettingsState(null, null)
    }
}