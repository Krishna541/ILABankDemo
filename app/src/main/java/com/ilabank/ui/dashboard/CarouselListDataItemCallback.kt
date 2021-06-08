package com.ilabank.ui.dashboard

import androidx.recyclerview.widget.DiffUtil
import com.ilabank.models.pojo.ListItemDataModel

class CarouselListDataItemCallback : DiffUtil.ItemCallback<ListItemDataModel>() {
    override fun areItemsTheSame(
        oldItem: ListItemDataModel,
        newItem: ListItemDataModel
    ): Boolean {
        return oldItem.SliderImageDataId == newItem.SliderImageDataId
    }

    override fun areContentsTheSame(
        oldItem: ListItemDataModel,
        newItem: ListItemDataModel
    ): Boolean {
        return oldItem == newItem
    }
}