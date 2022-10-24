package com.example.putzkowapp

import android.content.Context
import android.graphics.Color
import android.widget.TextView
import com.example.putzkowapp.Board2

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.example.putzkowapp.MainActivity

class Board {
    companion object {
        var bewohner = ArrayList<String>(6);
        var d: Int = 0

        fun init(save: Int){
            if(save!=-1){
                d = save
            }
            bewohner.add("Richard")
            bewohner.add("Magnus")
            bewohner.add("Wu")
            bewohner.add("Vinod")
            bewohner.add("Louis")
            bewohner.add("Maik")
        }

        fun name():String{return bewohner.get(d)}

        fun p_name(): String {
            d++
            if(d>5){
                d=0
            }
            return bewohner.get(d)
        }

        fun m_name(): String {
            d--
            if(d<0){
                d=5
            }
            return bewohner.get(d)
        }

        fun textcolor(table: Array<TextView>, text2: String): Int{
            var save: Int = 0
            for (v in 0..5){
                if(table[v].text==text2){
                    table[v].setTextColor(Color.parseColor("#8a2be2"))
                    save = v
                } else {
                    table[v].setTextColor(Color.parseColor("#B1B1B1"))
                }
            }
            return save
        }




        fun refresh(table: Array<TextView>){
            for(i in 0..5){
                if(i<3){
                    table[i].text = Board2.kitchen.get(i).name
                } else {
                    table[i].text = Board2.bathroom.get(i-3).name
                }
            }
        }
    }

}

