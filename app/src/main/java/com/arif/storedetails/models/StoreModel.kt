package com.arif.storedetails.models
import com.google.gson.annotations.SerializedName


data class StoreInfo(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
) {
    data class Data(
        @SerializedName("address")
        val address: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )

    data class Links(
        @SerializedName("first")
        val first: String,
        @SerializedName("last")
        val last: String,
        @SerializedName("next")
        val next: String,
        @SerializedName("prev")
        val prev: Any
    )

    data class Meta(
        @SerializedName("current_page")
        val currentPage: Int,
        @SerializedName("from")
        val from: Int,
        @SerializedName("last_page")
        val lastPage: Int,
        @SerializedName("path")
        val path: String,
        @SerializedName("per_page")
        val perPage: Int,
        @SerializedName("to")
        val to: Int,
        @SerializedName("total")
        val total: Int
    )
}