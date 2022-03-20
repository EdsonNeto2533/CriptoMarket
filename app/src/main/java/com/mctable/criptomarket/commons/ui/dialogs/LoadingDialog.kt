package com.mctable.criptomarket.commons.ui.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.mctable.criptomarket.R
import com.mctable.criptomarket.databinding.FragmentLoadingDialogBinding

class LoadingDialog(private val activity: AppCompatActivity) :
    DialogFragment() {

    companion object {
        private const val TAG = "loading_dialog"
    }

    private lateinit var binding: FragmentLoadingDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity.layoutInflater.inflate(R.layout.fragment_loading_dialog, null)
        binding = FragmentLoadingDialogBinding.bind(view)

        val dialog = AlertDialog.Builder(activity)
        dialog.setView(view)

        return dialog.create()
    }

    fun show() {
        this.show(activity.supportFragmentManager, TAG)
    }

}