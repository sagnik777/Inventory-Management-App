package com.example.inventorymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appContext = applicationContext

        LoginScreenFunctionality.init(appContext)

        val inputUserName = findViewById<EditText>(R.id.editTextInputUserName)
        val inputPassword = findViewById<EditText>(R.id.editTextInputPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)

        LoginScreenFunctionality.login(inputUserName, inputPassword, loginButton)
    }
}