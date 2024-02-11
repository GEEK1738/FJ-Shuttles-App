package com.example.shuttle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    lateinit var getButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getButton = findViewById(R.id.getButton)

        getButton.setOnClickListener {
            val bookTripIntent = Intent(this, BookTripActivity::class.java)
            startActivity(bookTripIntent)
        }

    }
}