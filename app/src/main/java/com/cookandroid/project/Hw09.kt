package com.cookandroid.project


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Hw09 : AppCompatActivity() {
    lateinit var resultButton: Button
    lateinit var nameEditText: EditText
    lateinit var heightEditText: EditText
    lateinit var weightEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hw09)

        resultButton = findViewById<Button>(R.id.resultButton)
        nameEditText = findViewById<EditText>(R.id.nameEditText)
        heightEditText = findViewById<EditText>(R.id.heightEditText)
        weightEditText = findViewById<EditText>(R.id.weightEditText)

        loadData()

        resultButton.setOnClickListener {
            saveData(heightEditText.text.toString().toInt(),
            weightEditText.text.toString().toInt())

            var intent = Intent(this, Hw09_result::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("height", heightEditText.text.toString())
            intent.putExtra("weihgt", weightEditText.text.toString())
            startActivity(intent)
        }

    }

    private fun saveData(height: Int, weight: Int){
        var pref = this.getPreferences(0)
        var editor = pref.edit()

        editor.putInt("KEY_NAME", nameEditText.text.toString().toInt()).apply()

        editor.putInt("KEY_HEIGHT", heightEditText.text.toString().toInt()).apply()
        editor.putInt("KEY_WEIGHT", weightEditText.text.toString().toInt()).apply()
    }

    private fun loadData(){
        var pref = this.getPreferences(0)

        var name = pref.getString("KEY_NAME", "")

        var height = pref.getInt("KEY_HEIGHT", 0)
        var weight = pref.getInt("KEY_WEIGHT", 0)


        if(name != "" && height !=0 && weight !=0){
            nameEditText.setText(name.toString())
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }
}

