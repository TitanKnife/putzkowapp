package com.example.putzkowapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.putzkowapp.cycling.Cycle
import com.example.putzkowapp.cycling.TextHandler
import java.util.LinkedList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var selectedPersonIndex = 0;
        var weekIndex = 0

        // UI Elements
        val selectedPersonTextView = findViewById<TextView>(R.id.text_val2)
        val weekIndexTextView = findViewById<TextView>(R.id.text_val)
        val table = arrayOf<TextView>(
            findViewById(R.id.table1),
            findViewById(R.id.table2),
            findViewById(R.id.table3),
            findViewById(R.id.table4),
            findViewById(R.id.table5),
            findViewById(R.id.table6),
        )

        // initialize people
        val people = listOf("Magnus", "Richard", "Louise", "Maik", "Wu", "Vinod");

        // initialize text Handlers
        val textHandlers = LinkedList<TextHandler>();
        people.forEachIndexed {
                index, person -> textHandlers.add(TextHandler(table[index], person))
        }

        // initialize Cycle control, ignore Vinod
        val mainCycle = Cycle(textHandlers, listOf("Vinod"));
        val bathCycle = Cycle(textHandlers.subList(3,6));
        fun moveCompleteCycle(direction: Int){
            var dir = direction;
            while (dir > 0){
                mainCycle.moveCycle(1);
                bathCycle.moveCycle(1);
                dir--;
            }
            while (dir < 0){
                bathCycle.moveCycle(-1);
                mainCycle.moveCycle(-1);
                dir++;
            }
        }

        // restore currently selected user, and week
        val restoredData = getData();
        selectedPersonTextView.text = people[restoredData.getOrDefault("userid", 0)]
        weekIndex = restoredData.getOrDefault("weekid", 0);
        // write current week Index to textfield
        weekIndexTextView.text = (weekIndex + 1).toString()
        // apply week index
        moveCompleteCycle(weekIndex);

        // render method to execute after each click
        fun render(){
            // save data
            saveData(selectedPersonIndex, weekIndex);

            // change color
            Board.textcolor(table, selectedPersonTextView.text.toString());
        }

        val plus = findViewById<Button>(R.id.button_p)
        plus.setOnClickListener{
            weekIndex = ((weekIndex + 1 + 15) % 15);
            weekIndexTextView.text = (weekIndex + 1).toString()
            moveCompleteCycle(1);
            render();
        }

        val minus = findViewById<Button>(R.id.button_m)
        minus.setOnClickListener{
            weekIndex = ((weekIndex - 1 + 15) % 15);
            weekIndexTextView.text = (weekIndex + 1).toString()
            moveCompleteCycle(-1);
            render();
        }

        val previousNameButton = findViewById<Button>(R.id.button_m2)
        previousNameButton.setOnClickListener{
            selectedPersonIndex = (selectedPersonIndex + people.count() - 1) % people.count();
            selectedPersonTextView.text = people[selectedPersonIndex];
            render();
        }
        val nextNameButton = findViewById<Button>(R.id.button_p2)
        nextNameButton.setOnClickListener{
            selectedPersonIndex = (selectedPersonIndex + 1) % people.count();
            selectedPersonTextView.text = people[selectedPersonIndex];
            render();
        }
        val reset = findViewById<Button>(R.id.reset)
        reset.setOnClickListener{
            Board.reset()
            Board.refresh(table)
        }

        // initial render
        render()
    }
    fun saveData(id:Int, weekId: Int){
       val sharedPreference =  getSharedPreferences("ID", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
         editor.putInt("userid",id)
         editor.putInt("weekid",weekId)
            editor.commit()
    }

    fun getData(): Map<String, Int>{
        val sharedPreference =  getSharedPreferences("ID", Context.MODE_PRIVATE)
        return mapOf("userid" to sharedPreference.getInt("userid", -1), "weekid" to sharedPreference.getInt("weekid", -1));
    }
}