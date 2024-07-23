package com.example.q3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val buttonApp1 = findViewById<Button>(R.id.btnApp1)
        val buttonApp2 = findViewById<Button>(R.id.btnApp2)

        buttonApp1.setOnClickListener {
            val intent = Intent().apply {
                setClassName("com.example.sum", "com.example.sum.MainActivity")
                putExtra("data", "Hello from MainApp to App1")
            }
            startActivity(intent)
        }

        buttonApp2.setOnClickListener {
            val intent = Intent().apply {
                setClassName("com.example.Q2", "com.example.Q2.MainActivity")
                putExtra("data", "Hello from MainApp to App2")
            }
            startActivity(intent)
        }
    }
}