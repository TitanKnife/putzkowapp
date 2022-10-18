package com.example.putzkowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Spoiler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spoiler)

        val main = Intent(this, MainActivity::class.java)
        Thread.sleep(4000)
        startActivity(main)
    }
}