package com.ilabank.activity

import androidx.databinding.ViewDataBinding
import com.ilabank.R
import com.ilabank.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun UIInitialization(binding: ViewDataBinding?) {
    }

    override fun InflateLayout(): Int {
        return R.layout.activity_main
    }
}