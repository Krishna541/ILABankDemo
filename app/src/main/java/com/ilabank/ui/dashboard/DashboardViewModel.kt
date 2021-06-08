package com.ilabank.ui.dashboard
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilabank.base.BaseModel
import com.ilabank.models.pojo.ListItemModel
import com.ilabank.models.pojo.ListItemDataModel
import com.ilabank.utils.Constant.Companion.LIST_ITEM_COUNT
import com.ilabank.utils.Constant.Companion.SLIDER_IMAGE_COUNT

class DashboardViewModel : BaseModel(){

    private val repository = DashboardRepository()

    private val _carouselData = MutableLiveData<List<ListItemModel>>()
    val carouselData: LiveData<List<ListItemModel>> = _carouselData

    private val _selectedCarouselListData = MutableLiveData<List<ListItemDataModel>>()
    val selectedCarouselListItemData: LiveData<List<ListItemDataModel>> = _selectedCarouselListData

    init {
        _carouselData.value =
            repository.dynamicCarouselData(SLIDER_IMAGE_COUNT, LIST_ITEM_COUNT)
    }

    fun postDataToCarousel(carouselListItemData: List<ListItemDataModel>) {
        _selectedCarouselListData.postValue(carouselListItemData)
    }

    fun getDataWithRespectToPosition(position: Int): List<ListItemDataModel> {
        return _carouselData.value?.get(position)?.data ?: listOf()
    }


}