package com.imani.childregistration

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val skip1=findViewById<TextView>(R.id.skip1)
        skip1.setOnClickListener {
            startActivity(Intent(applicationContext,Parent_registration::class.java))
        }
        val next=findViewById<FloatingActionButton>(R.id.fab)
        next.setOnClickListener {
            startActivity(Intent(applicationContext,Screen2::class.java))
        }
    }
}