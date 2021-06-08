package com.ilabank.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.ilabank.R
import com.ilabank.databinding.DashboardItemFragmentBinding
import com.ilabank.models.pojo.ListItemModel


class DashboardViewPagerAdapter : PagerAdapter() {

    var dataList: List<ListItemModel> = arrayListOf()

    override fun isViewFromObject(view: View, Object: Any): Boolean {
        return view === Object as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = DataBindingUtil.inflate<DashboardItemFragmentBinding>(
            LayoutInflater.from(container.context),
            R.layout.dashboard_item_fragment,
            container,
            false
        )

        binding.ivSliderImage.setImageResource(dataList[position].SliderImage)
        container.addView(binding.root)
        return binding.root
    }

    override fun getCount(): Int = dataList.size

    override fun destroyItem(container: ViewGroup, position: Int, Object: Any) {
        container.removeView(Object as ConstraintLayout)
    }


    fun addItems(list: List<ListItemModel>) {
        dataList = list
        notifyDataSetChanged()
    }
}