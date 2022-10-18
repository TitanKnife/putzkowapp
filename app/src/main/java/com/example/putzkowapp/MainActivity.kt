package com.example.putzkowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import com.example.putzkowapp.util.Board

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent(this, MainActivity2::class.java)
//        startActivity(intent)
//        finish()


        var i = 0

        val text = findViewById<TextView>(R.id.text_val)
        val title = findViewById<TextView>(R.id.app_title)

        val table = arrayOf<TextView>(findViewById<TextView>(R.id.table1), findViewById<TextView>(R.id.table2), findViewById<TextView>(R.id.table3), findViewById<TextView>(R.id.table4), findViewById<TextView>(R.id.table5), findViewById<TextView>(R.id.table6))

        Board.init()
        Board.refresh(table,    i)

        val plus = findViewById<Button>(R.id.button_p)
        plus.setOnClickListener{
            i++
            if(i>5){
                i=0
            }
            text.setText(i.toString())
            Board.refresh(table,    i)
        }

        val minus = findViewById<Button>(R.id.button_m)
        minus.setOnClickListener{
            i--
            if(i<1){
                i=5
            }
            text.setText(i.toString())
            Board.refresh(table,    i)
        }
    }
}