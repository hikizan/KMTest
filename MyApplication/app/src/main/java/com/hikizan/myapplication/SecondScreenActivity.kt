package com.hikizan.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hikizan.myapplication.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        binding.tvName.text = name

        binding.btnChooseUser.setOnClickListener {
            val move = Intent(this, ThirdScreenActivity::class.java)
            startActivity(move)
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}