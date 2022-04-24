package com.mctable.criptomarket.commons.di

import androidx.appcompat.app.AppCompatActivity
import com.mctable.criptomarket.commons.ui.dialogs.ErrorDialog
import com.mctable.criptomarket.commons.ui.dialogs.ErrorDialogInfoModel
import com.mctable.criptomarket.commons.ui.dialogs.LoadingDialog
import org.koin.dsl.module

val dialogModule = module {
    factory { (activity: AppCompatActivity) ->
        LoadingDialog(activity)
    }

    factory { (activity: AppCompatActivity, errorDialog: ErrorDialogInfoModel) ->
        ErrorDialog(activity, errorDialog)
    }
}