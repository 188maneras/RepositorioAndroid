package com.example.myapplicationmateo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import com.example.myapplicationmateo.R.id.textView2

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

   var txtSpec: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtSpec = TextToSpeech(this, this)


        findViewById<Button>(R.id.bntPlay).setOnClickListener() {
speak()
        }

    }

    private fun speak() {
        var message: String = findViewById<TextView>(textView2).text.toString()
        txtSpec!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")


    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            findViewById<TextView>(textView2).text ="Listo!"
        }else{
            findViewById<TextView>(textView2).text="No disponible!"
        }
        }
    }

