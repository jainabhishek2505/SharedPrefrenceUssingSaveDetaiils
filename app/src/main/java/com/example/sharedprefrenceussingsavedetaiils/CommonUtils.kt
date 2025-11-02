package com.example.sharedprefrenceussingsavedetaiils

import android.content.Context
import android.util.Patterns
import android.widget.Toast

class CommonUtils {
    companion object{
        fun showToast(context: Context, msg: String?) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        fun checkValidation(context: Context, email: String, password: String): Boolean {
            return when {
                email.isEmpty() -> {
                    Toast.makeText(context, "Enter Email", Toast.LENGTH_SHORT).show()
                    false
                }
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    Toast.makeText(context, "Enter valid Email", Toast.LENGTH_SHORT).show()
                    false
                }
                password.isEmpty() -> {
                    Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show()
                    false
                }
                password.length < 6 -> {
                    Toast.makeText(context, "Password must be 6+ characters", Toast.LENGTH_SHORT).show()
                    false
                }

                else -> true
            }
        }

    }
}