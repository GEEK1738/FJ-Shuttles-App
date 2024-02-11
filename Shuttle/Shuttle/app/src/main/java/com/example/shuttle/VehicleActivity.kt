package com.example.shuttle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class VehicleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle)

        val buttonClick = findViewById<Button>(R.id.finishbutton)

        buttonClick.setOnClickListener {
            val intent = Intent(this, EndActivity::class.java)
            startActivity(intent)
        }

        val r1 = findViewById<RadioButton>(R.id.quantumButton)
        val r2 = findViewById<RadioButton>(R.id.rumionButton)
        val r3 = findViewById<RadioButton>(R.id.corollaButton)
        val r4 = findViewById<RadioButton>(R.id.cashButton)
        val r5 = findViewById<RadioButton>(R.id.creditButton)


        r1.setOnCheckedChangeListener { button, isChecked ->
            Toast.makeText(this,isChecked.toString(), Toast.LENGTH_SHORT).show()
        }
        r2.setOnCheckedChangeListener { button, isChecked ->
            Toast.makeText(this,isChecked.toString(), Toast.LENGTH_SHORT).show()
        }
        r3.setOnCheckedChangeListener { button, isChecked ->
            Toast.makeText(this,isChecked.toString(), Toast.LENGTH_SHORT).show()
        }
        r4.setOnCheckedChangeListener { button, isChecked ->
            Toast.makeText(this,isChecked.toString(), Toast.LENGTH_SHORT).show()
        }
        r5.setOnCheckedChangeListener { button, isChecked ->
            Toast.makeText(this,isChecked.toString(), Toast.LENGTH_SHORT).show()
        }

    }
}