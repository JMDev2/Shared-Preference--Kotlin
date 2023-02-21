package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreference = getSharedPreferences("myPreference", MODE_PRIVATE)
        val editor = sharedPreference.edit()

        binding.apply {
            saveBtn.setOnClickListener {
                val userName = name.text.toString()
                val email = email.text.toString()

                editor.apply(){
                    putString("user_name", userName)
                    putString("email", email)
                    apply()
                }
            }
            loadBtn.setOnClickListener {
                val userName = sharedPreference.getString("user_name", null)
                val email = sharedPreference.getString("email", null)

                nameTxt.text = userName
                emailTxt.text = email
            }
        }

    }
}