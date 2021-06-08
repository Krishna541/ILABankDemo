package com.ilabank.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ilabank.R
import com.ilabank.databinding.DashboardListItemRowBinding
import com.ilabank.models.pojo.ListItemDataModel
import com.ilabank.utils.FilterListItem


class DashboardRecyclerAdapter(val showEmptyView: (Boolean) -> Unit) :
    ListAdapter<ListItemDataModel, DashboardRecyclerAdapter.DashboardRecyclerViewHolder>(
        CarouselListDataItemCallback()
    ),
    Filterable {

    var dataList = listOf<ListItemDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardRecyclerViewHolder {
        val binding = DataBindingUtil.inflate<DashboardListItemRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.dashboard_list_item_row,
            parent,
            false)
        return DashboardRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setOriginalList(data: List<ListItemDataModel>) {
        dataList = data
        submitList(data)
    }

    class DashboardRecyclerViewHolder(private val mBinding: DashboardListItemRowBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(carouselListItemItemData: ListItemDataModel) {
            mBinding.sliderImageListItemData = carouselListItemItemData
            mBinding.executePendingBindings()
        }
    }

    override fun getFilter(): Filter {
        return FilterListItem<ListItemDataModel>(dataList) {
            submitList(it)
            showEmptyView(it.isNullOrEmpty())
        }
    }
}

