package com.cookandroid.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Hw02 : AppCompatActivity() {
    lateinit var textView1:TextView
    lateinit var button1:Button
    lateinit var editText1:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hw02)

        button1 = findViewById(R.id.button1)
        textView1 = findViewById(R.id.textView1)
        editText1 = findViewById(R.id.editText1)

        button1.setOnClickListener {
            textView1.text = editText1.text.toString()
        }
    }
}