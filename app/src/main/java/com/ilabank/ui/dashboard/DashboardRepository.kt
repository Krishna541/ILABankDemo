package com.ilabank.ui.dashboard

import com.ilabank.R
import com.ilabank.models.pojo.ListItemModel
import com.ilabank.models.pojo.ListItemDataModel


class DashboardRepository {

    private val data = mutableListOf<ListItemModel>()

    fun dynamicCarouselData(
        listCount: Int = 1,
        listItemCount: Int = 1
    ): List<ListItemModel> {
        data.clear()
        for (i in 1..listCount) {
            val temp = mutableListOf<ListItemDataModel>()
            for (j in 1..listItemCount) {
                temp.add(
                    ListItemDataModel(
                        id = i,
                        SliderImageDataId = j,
                        sliderimage = R.mipmap.app_icon,
                        imagetext = "ILA Bank ${i.times(0).plus(j)}"
                    )
                )
            }

            data.add(
                ListItemModel(
                    sliderimageId = i,
                    SliderImage = R.mipmap.slider_image,
                    data = temp
                )
            )
        }
        return data
    }

}