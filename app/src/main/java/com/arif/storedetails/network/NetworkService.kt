package com.arif.storedetails.network

import com.arif.storedetails.models.StoreInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val base_url = "http://128.199.215.102:4040/"

val retrofit = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface StoreDetailsApi{
    @GET("api/stores")
    suspend fun getStoreData(
        @Query("page") page:Int
    ) : StoreInfo
}

object NetworkService{
    val storeDetailsApi: StoreDetailsApi by lazy {
        retrofit.create(StoreDetailsApi::class.java)
    }
}