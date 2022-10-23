package com.example.putzkowapp

import java.util.Collections

class Board2 {
    companion object {
        var kitchen = ArrayList<Students>()
        var bathroom = ArrayList<Students>()

        fun init(){
            kitchen.add(Students("Richard", false))
            kitchen.add(Students("Magnus", false))
            kitchen.add(Students("Wu", false))

            bathroom.add(Students("Vinod", true))
            bathroom.add(Students("Louis", false))
            bathroom.add(Students("Maik", false))
        }

        fun switch(){
            bathroom.add(kitchen.get(0))
            kitchen.removeAt(0)

            if(bathroom.get(0).inder==true){
                Collections.rotate(bathroom, -1)
            }

            kitchen.add(bathroom.get(0))
            bathroom.removeAt(0)
        }

        fun backswitch(){

            bathroom.add(0, kitchen.get(2))
            kitchen.removeAt(2)

            if(bathroom.get(3).inder==true){
                Collections.rotate(bathroom, 1)
            }
            kitchen.add(0, bathroom.get(3))
            bathroom.removeAt(3)

        }
    }
}
