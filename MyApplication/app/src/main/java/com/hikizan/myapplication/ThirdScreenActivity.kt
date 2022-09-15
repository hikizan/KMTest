package com.hikizan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hikizan.myapplication.adapter.UserAdapter
import com.hikizan.myapplication.databinding.ActivityThirdScreenBinding
import com.hikizan.myapplication.network.model.DataItem

class ThirdScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.setHasFixedSize(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ThirdScreenViewModel::class.java]
        viewModel.listUsers.observe(this) { users ->
            Log.d(TAG, "onCreate: data = $users")
            setDataUsers(users)
        }
    }

    private fun setDataUsers(users: List<DataItem>) {
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(users)
        binding.rvUsers.adapter = adapter
    }

    companion object {
        val TAG = "ThirdScreenActivity"
    }
}