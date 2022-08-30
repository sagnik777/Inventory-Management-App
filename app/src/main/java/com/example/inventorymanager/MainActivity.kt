package com.example.inventorymanager

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appContext = applicationContext

        LoginScreen.init(appContext)

        val inputUserName = findViewById<EditText>(R.id.editTextInputUserName)
        val inputPassword = findViewById<EditText>(R.id.editTextInputPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)

        LoginScreen.login(inputUserName, inputPassword, loginButton)
    }
}