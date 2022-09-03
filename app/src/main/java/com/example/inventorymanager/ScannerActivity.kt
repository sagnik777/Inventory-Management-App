package com.example.inventorymanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ScannerActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_scanner)

        //Init bottomNavigationView
        val appContext = applicationContext
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.navigation_scanner

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
    }

}