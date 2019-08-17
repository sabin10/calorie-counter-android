package com.sabinhantu.caloriecounter.calendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sabinhantu.caloriecounter.MainActivity
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.constructDate
import kotlinx.android.synthetic.main.activity_calendar.*

class CalendarActivity : AppCompatActivity() {

    private var selectedDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarview.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = constructDate(year, month + 1, dayOfMonth)
        }

        btn_select_date.setOnClickListener {
            intentToMain(selectedDate)
        }
    }

    private fun intentToMain(newDate: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("date", newDate)
        startActivity(intent)
    }


}
