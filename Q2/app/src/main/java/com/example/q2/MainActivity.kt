package com.example.q2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var spinnerPriority: Spinner
private lateinit var buttonAddTask: Button
private lateinit var listViewTasks: ListView
private lateinit var textTask: EditText
private val tasks = mutableListOf<String>()
private lateinit var adapter: ArrayAdapter<String>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        spinnerPriority = findViewById(R.id.spinnerPriority)
        buttonAddTask = findViewById(R.id.buttonAddTask)
        listViewTasks = findViewById(R.id.listViewTasks)
        textTask = findViewById(R.id.txttask)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        listViewTasks.adapter = adapter

        spinnerPriority.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val priority = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Selected: $priority", Toast.LENGTH_SHORT).show()
                filterTasks(priority)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        buttonAddTask.setOnClickListener {
            val taskText = textTask.text.toString()
            tasks.add("$taskText - ${spinnerPriority.selectedItem}")
            textTask.text.clear()
            adapter.notifyDataSetChanged()
        }
    }
    private fun filterTasks(priority: String) {
        // Implement task filtering based on priority
        // For simplicity, we're not actually filtering here
        // This is where you would add your filtering logic
    }
}