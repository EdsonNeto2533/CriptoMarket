package com.mctable.criptomarket.commons.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mctable.criptomarket.R
import com.mctable.criptomarket.databinding.FragmentErrorDialogBinding
import org.koin.core.component.getScopeId

data class ErrorDialogInfoModel(
    val text: String?,
    val buttonAction: () -> Unit
)

class ErrorDialog(
    private val activity: AppCompatActivity,
    private val errorDialogInfoModel: ErrorDialogInfoModel
) : BottomSheetDialogFragment() {

    companion object {
        private const val ERROR_DIALOG_TAG = "error_dialog"
    }

    private lateinit var binding: FragmentErrorDialogBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentErrorDialogBinding.bind(view)
        setupDialogInfo()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return activity.layoutInflater.inflate(R.layout.fragment_error_dialog, null)
    }

    private fun setupDialogInfo() {
        errorDialogInfoModel.text?.let {
            binding.tvErrorMessage.text = it
        }

        binding.mbtTryAgain.setOnClickListener {
            errorDialogInfoModel.buttonAction.invoke()
            dismiss()
        }
    }

    fun show() {
        show(activity.supportFragmentManager, ERROR_DIALOG_TAG)
    }


}