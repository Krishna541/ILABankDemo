package com.ilabank.base

import android.content.Context
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableBoolean

open class BaseViewModel<N>(private var navigator: N, protected var context: Context) :
    BaseObservable() {

    var isBackShow: ObservableBoolean = ObservableBoolean(false)

    fun onBackArrowPress() {
        (navigator as BaseNavigator).onBack()
    }

    fun onViewClick(view: View) {
        (navigator as BaseNavigator).onBack()
        isBackShow.set(false)
    }

}