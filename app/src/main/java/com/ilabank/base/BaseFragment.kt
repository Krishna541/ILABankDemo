package com.ilabank.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment


abstract class BaseFragment : Fragment(),BaseNavigator {

    private lateinit var binding: ViewDataBinding

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false)
        return binding.root
    }

    open fun moveToFragment(@IdRes fragmentactionID: Int) {
        NavHostFragment.findNavController(this).navigate(fragmentactionID)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onIntializedView(binding, view)
        super.onViewCreated(view, savedInstanceState)
    }


    fun finish() {
        (activity as BaseActivity).finish()
    }

    fun onBackPressed(){
        (activity as BaseActivity).finish()
    }


}