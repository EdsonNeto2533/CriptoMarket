package com.mctable.criptomarket.commons.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.mctable.criptomarket.R
import com.mctable.criptomarket.databinding.FragmentErrorDialogBinding

data class ErrorDialogInfoModel(
    val text: String?,
    val buttonAction: () -> Unit
)

class ErrorDialog(
    private val activity: AppCompatActivity,
    private val errorDialogInfoModel: ErrorDialogInfoModel
) : DialogFragment() {

    companion object {
        private const val ERROR_DIALOG_TAG = "error_dialog"
    }

    private lateinit var binding: FragmentErrorDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity.layoutInflater.inflate(R.layout.fragment_loading_dialog, null)
        binding = FragmentErrorDialogBinding.bind(view)

        val dialog = AlertDialog.Builder(activity)
        dialog.setView(view)

        setupDialogInfo()

        return super.onCreateDialog(savedInstanceState)
    }

    private fun setupDialogInfo() {
        errorDialogInfoModel.text?.let {
            binding.tvErrorMessage.text = it
        }

        binding.mbtTryAgain.setOnClickListener {
            errorDialogInfoModel.buttonAction
            dismiss()
        }
    }

    fun show() {
        show(activity.supportFragmentManager, ERROR_DIALOG_TAG)
    }


}