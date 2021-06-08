package com.ilabank.models.pojo

import androidx.annotation.DrawableRes

data class ListItemModel(
    val sliderimageId: Int,
    @DrawableRes val SliderImage: Int,
    val data: List<ListItemDataModel>,
    )