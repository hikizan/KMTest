package com.hikizan.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.hikizan.myapplication.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding
    private val title: String = "Second Screen"
    private lateinit var selectedName: String

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.data!=null && result.resultCode==ThirdScreenActivity.RESULT_CODE){
            selectedName = result.data?.getStringExtra(ThirdScreenActivity.EXTRA_RESULT).toString()
            setChoosenUser(selectedName)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        binding.tvName.text = name

        binding.btnChooseUser.setOnClickListener {
            val move = Intent(this, ThirdScreenActivity::class.java)
            resultLauncher.launch(move)
            supportActionBar?.title = title
        }
    }

    private fun setChoosenUser(name: String){
        binding.tvSelectedName.text = name
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}