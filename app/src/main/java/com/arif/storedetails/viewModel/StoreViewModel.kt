package com.arif.storedetails.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arif.storedetails.models.StoreInfo
import com.arif.storedetails.repos.StoreRepository
import kotlinx.coroutines.launch

class StoreViewModel : ViewModel() {
    val storeLiveData: MutableLiveData<StoreInfo> = MutableLiveData()
    val repository = StoreRepository()

    fun fetchData(page:Int){
        viewModelScope.launch {
            try {
                storeLiveData.value = repository.fetchStoreData(page)
            }catch (e:Exception){
                Log.d("storeViewModel", e.localizedMessage)
            }
        }
    }

}