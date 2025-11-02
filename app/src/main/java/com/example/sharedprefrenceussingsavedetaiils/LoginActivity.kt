package com.example.sharedprefrenceussingsavedetaiils

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedprefrenceussingsavedetaiils.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    var shName: String? = null
    var shEmail: String? = null
    var shPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDetailsFromSharedPref()
        init()
    }

    private fun getDetailsFromSharedPref() {
        val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        shName = sharedPref.getString("name", null) //receive data from main activity
        shEmail = sharedPref.getString("email", null)
        shPassword = sharedPref.getString("password", null)
    }

    private fun init() {
        binding.loginBtn.setOnClickListener {
            checkDetails()
        }
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


/*    fun checkDetails() {


        val loginEmail = binding.etEmail.getText().toString()
        val loginPass = binding.etPass.getText().toString()

        if (CommonUtils.checkValidation(this, loginEmail, loginPass)) {
            if (loginEmail != shEmail) {
                CommonUtils.showToast(this, getResources().getString(R.string.Email_check))
            } else if (loginPass != shPassword) { //cl condition false pass incorrect
                CommonUtils.showToast(this, getResources().getString(R.string.Password_check))
            } else {
                CommonUtils.showToast(this, "Login successful ✅")
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }*/

    //one more updated code both working same
    fun checkDetails() {
        val loginEmail = binding.etEmail.text.toString().trim()
        val loginPass = binding.etPass.text.toString().trim()

        // Step 1: Validate using CommonUtils
        if (!CommonUtils.checkValidation(this, loginEmail, loginPass)) return

       /** This return means that if the validation fails,
        the function stops right here and does not execute any code below.**/

        // Step 2: Compare saved vs entered values
        when {
            shEmail == null || shPassword == null -> {
                CommonUtils.showToast(this,
                    getString(R.string.no_account_found_please_register_first))
            }
            loginEmail != shEmail -> {
                CommonUtils.showToast(this, getString(R.string.Email_check))
            }
            loginPass != shPassword -> {
                CommonUtils.showToast(this, getString(R.string.Password_check))
            }
            else -> {
                //  Success → navigate
                CommonUtils.showToast(this, "Login successful ✅")
                val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putBoolean("isLoggedIn", true)   // ✅ save login status
                editor.apply()

                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}