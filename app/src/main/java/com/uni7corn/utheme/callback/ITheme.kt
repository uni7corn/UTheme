package com.uni7corn.utheme.callback

import android.view.View

interface ITheme {

    fun getView(): View

    fun updateTheme(themeSuffix: String)
}