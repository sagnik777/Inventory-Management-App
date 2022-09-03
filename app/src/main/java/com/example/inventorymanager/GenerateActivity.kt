package com.example.inventorymanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.json.JSONObject

class GenerateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_generator)

        //Get application Context
        val appContext = applicationContext
        var userData: JSONObject

        //Init bottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.navigation_generator

        //Generator
        val etInventoryType = findViewById<EditText>(R.id.editTextInventoryType)
        val etSerialId = findViewById<EditText>(R.id.editTextSerialId)
        val etModelName = findViewById<EditText>(R.id.editTextModelName)
        val etOwnerName = findViewById<EditText>(R.id.editTextOwnerName)
        val etOwnerContact = findViewById<EditText>(R.id.editTextOwnerContact)
        val etOwnerKUID = findViewById<EditText>(R.id.editTextOwnerKUID)
        val btGenerate = findViewById<Button>(R.id.generateBtn)
        val ivOutput = findViewById<ImageView>(R.id.idIVQrcode)
        val tbQrOutput = findViewById<TextView>(R.id.textQrOutput)

        bottomNavigationView.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.navigation_generator -> {
                    val generatorIntent = Intent(appContext, GenerateActivity::class.java)
                    generatorIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    appContext.startActivity(generatorIntent)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_scanner -> {
                    val scannerIntent = Intent(appContext, ScannerActivity::class.java)
                    scannerIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    appContext.startActivity(scannerIntent)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_details -> {
                    val detailsIntent = Intent(appContext, DetailsPageActivity::class.java)
                    detailsIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    appContext.startActivity(detailsIntent)
                    return@setOnItemSelectedListener true
                }

                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }

        btGenerate.setOnClickListener{
             userData = GenerateQrFunctionality.readUserData(
                etInventoryType,
                etSerialId,
                etModelName,
                etOwnerName,
                etOwnerContact,
                etOwnerKUID
            )

            val qrText = userData.get(Constants.userData.dataInventoryType).toString() +
                    userData.get(Constants.userData.dataSerialId).toString() +
                    userData.get(Constants.userData.dataModelName).toString()

            val qrImage = GenerateQrFunctionality.generateQrCode(qrText)
            ivOutput.setImageBitmap(qrImage)
            tbQrOutput.text = userData.toString()
            GenerateQrFunctionality.resetInputFields(etInventoryType,
                etSerialId,
                etModelName,
                etOwnerName,
                etOwnerContact,
                etOwnerKUID)
        }
    }
}