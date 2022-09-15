package com.hikizan.myapplication.network

import com.hikizan.myapplication.network.model.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/users")
    fun getListUsers(@Query("page") page: String): Call<UsersResponse>
}