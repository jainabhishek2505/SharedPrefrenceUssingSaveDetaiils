package com.example.sharedprefrenceussingsavedetaiils

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedprefrenceussingsavedetaiils.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userSession()

    }

    private fun init() {
        binding.registerBtn.setOnClickListener {
            signUpDetails()
        }

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    fun signUpDetails() {
        val name = binding.etName.getText().toString()
        val email = binding.etEmail.getText().toString()
        val password = binding.etPass.getText().toString()

        if (CommonUtils.checkValidation(this, email, password)) {
            saveDetails(email, password, name)
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun saveDetails(email: String, password: String, name: String) {
        val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()

    }


    fun userSession(){
        val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            init()
        }
    }

}