package com.cookandroid.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch


class TorchActivity : AppCompatActivity() {

    lateinit var flashSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.torch)

        flashSwitch = findViewById(R.id.flashSwitch)
        val torch = Torch(this)
        val intent = Intent(this, TorchService::class.java)

        flashSwitch.setOnCheckedChangeListener{ buttonView, isChecked ->
            if(isChecked){
                intent.action = "on"
                startService(intent)
            }
            else{
                intent.action = "off"
                startService(intent)
            }
        }
    }
}