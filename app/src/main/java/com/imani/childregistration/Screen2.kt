package com.imani.childregistration

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val skip2 = findViewById<TextView>(R.id.skip2)
        skip2.setOnClickListener {
            val intent = Intent(this, Parent_registration::class.java)
            startActivity(intent)
        }
        val next = findViewById<FloatingActionButton>(R.id.fab2)
        next.setOnClickListener {
            val intent = Intent(this, Parent_registration::class.java)
            startActivity(intent)
        }


    }
}