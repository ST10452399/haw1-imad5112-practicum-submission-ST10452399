
package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_screen)

        val days = intent.getStringArrayListExtra("days") ?: arrayListOf()
        val minimum = intent.getIntegerArrayListExtra("minimum") ?: arrayListOf()
        val maximum = intent.getIntegerArrayListExtra("maximum") ?: arrayListOf()
        val conditions = intent.getStringArrayListExtra("conditions") ?: arrayListOf()

        val txtDetails = findViewById<TextView>(R.id.txtDetails)
        val txtMin = findViewById<TextView>(R.id.txtMin)
        val txtMax = findViewById<TextView>(R.id.txtMax)
        val txtCondition = findViewById<TextView>(R.id.txtConditions)
        val btnMainScreen = findViewById<Button>(R.id.btnMainScreen)

        val detailsBuilder = StringBuilder()
        val minBuilder = StringBuilder()
        val maxBuilder = StringBuilder()
        val conditionBuilder = StringBuilder()
// this is how the information should be displayed on this page
        for (i in days.indices) {
            detailsBuilder.append("${days[i]}\n")
            minBuilder.append("${minimum[i]}\n")
            maxBuilder.append("${maximum[i]}\n")
            conditionBuilder.append("${conditions[i]}\n")
        }
//instructing what has to be displayed
        txtDetails.text = detailsBuilder.toString()
        txtMin.text = minBuilder.toString()
        txtMax.text = maxBuilder.toString()
        txtCondition.text = conditionBuilder.toString()
//button is instructed to return back to the main screen
        btnMainScreen.setOnClickListener {
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
        }
    }
}
