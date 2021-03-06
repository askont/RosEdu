package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.dialog_main_task_network_settings.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.core.BaseDialogFragment
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings.state.NetworkSettingsState
import ru.leadersofdigital.rosedu.R

class NetworkSettingsDialogFragment : BaseDialogFragment<NetworkSettingsState, NetworkSettingsViewModel>() {

    override val viewModel: NetworkSettingsViewModel by viewModel()
    override val layoutRes: Int = R.layout.dialog_main_task_network_settings

    companion object {
        fun newInstance() = NetworkSettingsDialogFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonApply.setOnClickListener {
            viewModel.onButtonSaveClick(
                editTextIpAddress.text.toString(),
                editTextIpMask.text.toString(),
                editTextIpAddress2.text.toString(),
                editTextIpMask2.text.toString()
            )
            dismiss()
        }

        buttonIpAddressDesc.setOnClickListener { showDescriptionAlert(R.string.common_ip_address, R.string.ip_address_description) }
        buttonIpMaskDesc.setOnClickListener { showDescriptionAlert(R.string.common_ip_mask, R.string.mask_description) }
        buttonIpAddressDesc2.setOnClickListener { showDescriptionAlert(R.string.common_ip_address, R.string.ip_address_description) }
        buttonIpMaskDesc2.setOnClickListener { showDescriptionAlert(R.string.common_ip_mask, R.string.mask_description) }
    }

    override fun renderState(state: NetworkSettingsState) {
        state.device?.let {
            textViewDeviceTitle.text =  resources.getString(R.string.device_title,it.name)
            textViewDeviceType.text = resources.getString(R.string.device_type,it.type.name)
            editTextIpAddress.setText(it.ipAddress1)
            editTextIpMask.setText(it.networkMask1)
        }

        state.iedDevices?.firstOrNull()?.let {
            textViewDeviceTitle.text =  resources.getString(R.string.device_title,it.name)
            textViewDeviceType.text = resources.getString(R.string.device_type,it.type.name)
        }

        state.iedDevices?.lastOrNull()?.let {
            textViewDeviceTitle2.text =  resources.getString(R.string.device_title,it.name)
            textViewDeviceType2.text = resources.getString(R.string.device_type,it.type.name)
        }
    }
}