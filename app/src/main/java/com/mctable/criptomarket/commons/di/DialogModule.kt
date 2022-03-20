package com.mctable.criptomarket.commons.di

import androidx.appcompat.app.AppCompatActivity
import com.mctable.criptomarket.commons.ui.dialogs.LoadingDialog
import org.koin.dsl.module

val dialogModule = module {
    factory { (activity: AppCompatActivity) ->
        LoadingDialog(activity)
    }
}