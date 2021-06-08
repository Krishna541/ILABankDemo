package com.ilabank.base

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import com.ilabank.R


abstract class BaseActivity : AppCompatActivity(), BaseInterFace, LifecycleOwner {

    private val baseViewModel: BaseModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // To Disable Dark theme by default


        var reslayout = InflateLayout()

        // Inflate View by Passing Layout from fragment  / Activity
        if (reslayout != 0) {
            val binding = DataBindingUtil.setContentView(this, reslayout) as ViewDataBinding
            UIInitialization(binding)
        }

    }

    fun setStatusBarPadding(binding: ViewDataBinding) {
        binding.root.setPadding(0, getStatusBarHeight(), 0, 0)
    }

    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId =
            resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }


    open fun moveToAnotherFragment(navigationaction: Int, bundle: Bundle?) {
        try {
            val navController = Navigation.findNavController(this, R.id.main_navigation)
            navController.navigate(navigationaction, bundle)
        } catch (w: Exception) {
        }
    }

    fun moveToAnotherFragment(navigationaction : Int){
        try {
            val navController = Navigation.findNavController(this, R.id.main_navigation)
            navController.navigate(navigationaction)
        } catch (w: Exception) {
        }
    }


}
