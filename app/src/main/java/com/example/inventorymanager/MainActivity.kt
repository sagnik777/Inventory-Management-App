package com.example.inventorymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login()
    }

    private fun login() {
        val inputUserName = findViewById<EditText>(R.id.editTextInputUserName)
        val inputPassword = findViewById<EditText>(R.id.editTextInputPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)
        var username = ""
        var password = ""

        loginButton.setOnClickListener {
            username = inputUserName.text.toString()
            password = inputPassword.text.toString()
        }
        val credentialResult = verifyCredentials(username, password)

        // Once Login success, launch intent to next activity -> activity_qr
        if (credentialResult) {
            // Launch another intent for qr scanning -> ActivityQR
            val qrActivityIntent = Intent(this, ActivityQR::class.java)
            startActivity(qrActivityIntent)
        }

    }

    private fun verifyCredentials(username: String, password: String): Boolean {
        val result = true
        // Use authenticator service and check for users

        return result
    }
}