package com.example.inventorymanager

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.util.Log
import android.widget.Button
import android.widget.EditText

object LoginScreenFunctionality {

    private lateinit var appContext: Context

    fun init(applicationContext: Context) {
        appContext = applicationContext
    }


    fun login(
        inputUserName: EditText,
        inputPassword: EditText,
        loginButton: Button
    ){

        var username: String
        var password: String

        loginButton.setOnClickListener {
            username = inputUserName.text.toString()
            password = inputPassword.text.toString()

            val result = verifyCredentials(username, password)
            if(result) {
                inputUserName.text.clear()
                inputPassword.text.clear()
                launchQRPage(appContext)
            }
        }
    }

    private fun launchQRPage(appContext: Context) {
        // Launch another intent for qr scanning -> ActivityQR
        val qrActivityIntent = Intent(appContext, GenerateActivity::class.java)
        qrActivityIntent.flags = FLAG_ACTIVITY_NEW_TASK
        appContext.startActivity(qrActivityIntent)
    }

    private fun verifyCredentials(username: String, password: String): Boolean {
        // Use authenticator service and check for users

        val verificationStatus: Boolean = if((Constants.loginUsernames.listUsername.contains(username)) && Constants.loginPasswords.userPassword == password) {
            Log.i("LoginScreen", "Not admin. Correct details")
            true
        } else if((Constants.loginUsernames.listAdminNames.contains(username)) && Constants.loginPasswords.adminPassword == password) {
            Log.i("LoginScreen", "Admin Login. Correct details")
            true
        } else {
            Log.i("LoginScreen","Invalid details")
            false
        }

        return verificationStatus
    }
}