package com.example.putzkowapp.util

import android.widget.TextView
import java.util.Collections

class Board {
    companion object {
        var bewohner = ArrayList<String>(6);

        fun init(){
            bewohner.add("Richard")
            bewohner.add("Magnus")
            bewohner.add("Wu")
            bewohner.add("Vinod")
            bewohner.add("Louis")
            bewohner.add("Maik")
        }


        fun refresh(table: Array<TextView>, q: Int){


            for(i in 0..5){
                var index = (i+q) % 6
                table[i].text = bewohner[index]
            }
        }
    }

}

