package com.example.putzkowapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent(this, MainActivity2::class.java)
//        startActivity(intent)
//        finish()


        var i = 1
        val text2 = findViewById<TextView>(R.id.text_val2)
        val text = findViewById<TextView>(R.id.text_val)
        val title = findViewById<TextView>(R.id.app_title)
        val table = arrayOf<TextView>(findViewById<TextView>(R.id.table1), findViewById<TextView>(R.id.table2), findViewById<TextView>(R.id.table3), findViewById<TextView>(R.id.table4), findViewById<TextView>(R.id.table5), findViewById<TextView>(R.id.table6))
        val id1 = findViewById<TextView>(R.id.id1)
        //id1.text = getData().toString()
        Board.init(getData())
        text2.setText(Board.name())
        Board2.init()
        Board.refresh(table)
        Board.textcolor(table, text2.text.toString())

        val plus = findViewById<Button>(R.id.button_p)
        plus.setOnClickListener{
            i++
            if(i>5){
                i=1
            }
            text.setText(i.toString())
            Board2.switch()
            Board.refresh(table)
            saveData(Board.textcolor(table, text2.text.toString()))
        }

        val minus = findViewById<Button>(R.id.button_m)
        minus.setOnClickListener{
            i--
            if(i<1){
                i=5
            }
            text.setText(i.toString())
            Board2.backswitch()
            Board.refresh(table)
            saveData(Board.textcolor(table, text2.text.toString()))
        }

        val mname = findViewById<Button>(R.id.button_m2)
        mname.setOnClickListener{
            text2.setText(Board.m_name())
            //saveData(Board.textcolor(table, text2.text.toString()))
        }
        val pname = findViewById<Button>(R.id.button_p2)
        pname.setOnClickListener{
            text2.setText(Board.p_name())
            //saveData(Board.textcolor(table, text2.text.toString()))
        }
        val reset = findViewById<Button>(R.id.reset)
        reset.setOnClickListener{
            Board.reset()
            Board.refresh(table)
        }
    }
    fun saveData(id:Int){
       val sharedPreference =  getSharedPreferences("ID", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
         editor.putInt("userid",id)
            editor.commit()
    }

    fun getData(): Int{
        val sharedPreference =  getSharedPreferences("ID", Context.MODE_PRIVATE)
        return sharedPreference.getInt("userid", -1)
    }
}