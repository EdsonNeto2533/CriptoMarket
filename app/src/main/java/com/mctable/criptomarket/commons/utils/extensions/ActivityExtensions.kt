package com.mctable.criptomarket.commons.utils.extensions

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.changeFragment(@IdRes container: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .addToBackStack(null).replace(container, fragment)
        .commit()
}