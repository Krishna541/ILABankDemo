package com.ilabank.models.pojo

import androidx.annotation.DrawableRes

data class ListItemDataModel(
    val id: Int,
    val SliderImageDataId: Int,
    @DrawableRes val sliderimage: Int,
    val imagetext: String
)