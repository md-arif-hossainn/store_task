package com.arif.storedetails.repos

import com.arif.storedetails.network.NetworkService
import com.arif.storedetails.models.StoreInfo

class StoreRepository {
    suspend fun fetchStoreData(page:Int) : StoreInfo {
        val response: StoreInfo = NetworkService.storeDetailsApi
            .getStoreData(page)
        return response
    }
}