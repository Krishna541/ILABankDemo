package com.ilabank.utils

import android.widget.Filter
import com.ilabank.models.pojo.ListItemDataModel

class FilterListItem<T>(
    private val dataListItem: List<ListItemDataModel>,
    val onFilter: (List<T>) -> Unit
) : Filter() {
    override fun performFiltering(ch: CharSequence?): FilterResults {
        var filteredList = mutableListOf<ListItemDataModel>()

        if (ch.isNullOrEmpty()) {
            filteredList = dataListItem.toMutableList()
        } else {
            for (i in dataListItem) {
                if (i.imagetext.contains(ch, ignoreCase = true))
                    filteredList.add(i)
            }
        }
        return FilterResults().apply { values = filteredList }
    }

    override fun publishResults(ch: CharSequence?, p1: FilterResults?) {
        try {
            onFilter(p1?.values as List<T>)
        } catch (e: Exception) {
            onFilter(listOf())
        }
    }

}