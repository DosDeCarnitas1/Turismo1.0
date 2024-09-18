package com.example.turismo10

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referencia a los ImageButtons
        val ibtnChichenitza = findViewById<ImageButton>(R.id.ibtnChichenitza)
        val ibtnCozumel = findViewById<ImageButton>(R.id.ibtnCozumel)
        val ibtnIslamujeres = findViewById<ImageButton>(R.id.ibtnIslamujeres)

        //Establecer un OnClickListener para cada ImageButton
        val intent = Intent(this, FormActivity::class.java)

        ibtnChichenitza.setOnClickListener {
            intent.putExtra("destination", "Chichen Itzá")
            startActivity(intent)
        }

        ibtnCozumel.setOnClickListener {
            intent.putExtra("destination", "Cozumel")
            startActivity(intent)
        }

        ibtnIslamujeres.setOnClickListener {
            intent.putExtra("destination", "Isla Mujeres")
            startActivity(intent)
        }
    }
}