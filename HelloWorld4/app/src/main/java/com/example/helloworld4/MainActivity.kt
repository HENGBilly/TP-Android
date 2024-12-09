package com.example.helloworld4

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld4.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Assurez-vous de lier l'activité à son layout
        setContentView(R.layout.activity_main)

        // Récupérer les références des vues
        val redButton: Button = findViewById(R.id.button)
        val greenButton: Button = findViewById(R.id.button2)
        val blueButton: Button = findViewById(R.id.button3)
        val panel: FrameLayout = findViewById(R.id.panel)

        // Actions pour chaque bouton
        redButton.setOnClickListener {
            panel.setBackgroundColor(Color.RED)  // Changer la couleur en rouge
        }

        greenButton.setOnClickListener {
            panel.setBackgroundColor(Color.GREEN)  // Changer la couleur en vert
        }

        blueButton.setOnClickListener {
            panel.setBackgroundColor(Color.BLUE)  // Changer la couleur en bleu
        }
    }
}
