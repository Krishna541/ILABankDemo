package com.ilabank.base

import android.view.View
import androidx.databinding.ViewDataBinding

interface BaseNavigator {
    fun onError(error: String)
    fun onBack()
    fun getLayoutID() : Int
    fun onIntializedView(binding: ViewDataBinding, view: View)
}