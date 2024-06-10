
package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainScreen : AppCompatActivity() {

    private val edtDayList = arrayListOf<String>()
    private val edtMinList = arrayListOf<Int>()
    private val edtMaxList = arrayListOf<Int>()
    private val edtConditionList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val edtDay = findViewById<EditText>(R.id.edtDay)
        val edtMin = findViewById<EditText>(R.id.edtMin)
        val edtMax = findViewById<EditText>(R.id.edtMax)
        val edtCondition = findViewById<EditText>(R.id.edtCondition)
        val btnNextPage = findViewById<Button>(R.id.btnNextPage)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        val txtAverage = findViewById<TextView>(R.id.txtAverage)


        btnNextPage.setOnClickListener {
            val day = edtDay.text.toString()
            val minimum = edtMin.text.toString().toIntOrNull()
            val maximum = edtMax.text.toString().toIntOrNull()
            val condition = edtCondition.text.toString()
//an if statement is being used here to prompt the used on what is required
            if (day.isNotEmpty() && minimum != null && maximum != null && condition.isNotEmpty()) {
                edtDayList.add(day)
                edtMinList.add(minimum)
                edtMaxList.add(maximum)
                edtConditionList.add(condition)
//here we are calculating the average temperature for the day
                val average = (minimum + maximum) / 2
                txtAverage.text = average.toString()

                Toast.makeText(this, "Data added", Toast.LENGTH_SHORT).show()

                clearEditTextFields(edtDay, edtMin, edtMax, edtCondition)
                clearTextViewField(txtAverage)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        btnClear.setOnClickListener {
            clearEditTextFields(edtDay, edtMin, edtMax, edtCondition)
            clearTextViewField(txtAverage)
            Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()
        }
// this button is instructed to go to the next page when clicked
        btnNextPage.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            intent.putStringArrayListExtra("days", edtDayList)
            intent.putIntegerArrayListExtra("minimum", edtMinList)
            intent.putIntegerArrayListExtra("maximum", edtMaxList)
            intent.putStringArrayListExtra("conditions", edtConditionList)
            startActivity(intent)
        }
// this button is instructed to return to the previous page.
        btnReturn.setOnClickListener {
            val intent = Intent(this, SplashScreen::class.java)
            startActivity(intent)
        }
    }

    private fun clearEditTextFields(edtDay: EditText, edtMin: EditText, edtMax: EditText, edtCondition: EditText) {
        edtDay.text.clear()
        edtMin.text.clear()
        edtMax.text.clear()
        edtCondition.text.clear()
    }

    private fun clearTextViewField(txtAverage: TextView) {
        txtAverage.text = ""
    }
}

