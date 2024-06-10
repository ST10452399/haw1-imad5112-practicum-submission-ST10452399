package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class SplashScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.btnNext)//this button is to welcome the user to the next page
        val btnExit = findViewById<Button>(R.id.btnExit)//this button the user to exit the app

        // instructing the button to do a action which leads the user to the next page.
        btnNext.setOnClickListener {
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            finish()
        }//instructing the button to allow the user to exit the app
    }
}