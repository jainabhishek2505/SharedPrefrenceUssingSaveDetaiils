package com.example.sharedprefrenceussingsavedetaiils

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedprefrenceussingsavedetaiils.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    var shName: String? = null
    var shEmail: String? = null
    var shPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){

        binding.btnLogout.setOnClickListener {
            val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
            sharedPref.edit().clear().apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        getDetailsFromSharedPref()




    }

    private fun getDetailsFromSharedPref() {
        val  sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        shName = sharedPref.getString("name",null) //receive data from main activity
        shEmail = sharedPref.getString("email",null)
        shPassword = sharedPref.getString("password",null)
        showOnUi()
    }

    fun showOnUi() {
        binding.tvName.text = shName
        binding.tvEmail.text = shEmail

    }
}