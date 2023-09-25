package com.example.lesson_5_homework_month_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById((R.id.tv_num))
        val buttonMinus: Button = findViewById(R.id.btn_minus)
        val buttonPlus: Button = findViewById(R.id.btn_plus)
        val buttonNext: Button = findViewById(R.id.btn_next)

        buttonPlus.setOnClickListener {
            count++
            textView.text = count.toString()
            if (textView.text.equals("10")) {
                buttonPlus.visibility = View.GONE
                buttonMinus.visibility = View.VISIBLE
            }
        }
        buttonMinus.setOnClickListener {
            if (textView.text.toString() > 0.toString())
                count--
            textView.text = count.toString()
        }
        buttonNext.setOnClickListener {
            if (textView.text.equals("0")) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("key", textView.text.toString())
                startActivity(intent)
            }
        }
    }
}