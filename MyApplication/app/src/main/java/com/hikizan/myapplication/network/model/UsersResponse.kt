package com.hikizan.myapplication.network.model


import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("data")
    val data: List<DataItem>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)