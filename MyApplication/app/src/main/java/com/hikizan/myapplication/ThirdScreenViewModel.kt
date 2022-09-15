package com.hikizan.myapplication

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Callback
import com.hikizan.myapplication.network.ApiConfig
import com.hikizan.myapplication.network.model.DataItem
import com.hikizan.myapplication.network.model.UsersResponse
import retrofit2.Call
import retrofit2.Response

class ThirdScreenViewModel : ViewModel() {

    private val _listUsers = MutableLiveData<List<DataItem>>()
    val listUsers: LiveData<List<DataItem>> = _listUsers

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        findListUsers()
    }

    private fun findListUsers() {
        val client = ApiConfig.getApiService().getListUsers("1")
        client.enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                if (response.isSuccessful){
                    _isLoading.value = false
                    _listUsers.value = response.body()?.data
                    Log.d(TAG, "onResponse: data = ${response.body()?.data}")
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                _isLoading.value = false
                //Toast.makeText(this, "RTO", Toast.LENGTH_LONG).show()
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }

    companion object {
        val TAG = "ViewModel"
    }
}