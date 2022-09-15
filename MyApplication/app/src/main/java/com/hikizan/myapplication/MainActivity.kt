package com.hikizan.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.hikizan.myapplication.databinding.ActivityMainBinding
import com.hikizan.myapplication.network.model.DataItem

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)

    }


    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_check -> {
                val valuePalindrome = binding.edtPalindrome.text.toString().trim()
                if (valuePalindrome.isEmpty()){
                    binding.edtPalindrome.error = "diisi dulu ya"
                }else{
                    isPalindrome(valuePalindrome)
                }
            }
            R.id.btn_next -> {
                val name = binding.edtName.text.toString()
                if (name.isEmpty()){
                    binding.edtName.error = "diisi dulu ya"
                } else {
                    val moveIntent = Intent(this@MainActivity, SecondScreenActivity::class.java)
                    moveIntent.putExtra(SecondScreenActivity.EXTRA_NAME, name)
                    startActivity(moveIntent)
                }
            }
        }
    }

    private fun isPalindrome(value: String) {
        for (i in 0..value.length / 2){
            val pointer1 = i
            val pointer2 = value.length - i - 1
            if (value[pointer1] != value[pointer2]){
                return Toast.makeText(this, "Not Palindrome", Toast.LENGTH_SHORT).show()
            }
        }
        return Toast.makeText(this, "Is Palindrome", Toast.LENGTH_SHORT).show()
    }
}