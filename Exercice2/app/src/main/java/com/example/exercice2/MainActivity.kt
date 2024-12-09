package com.example.exercice2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Références des boutons et de l'ImageView
        val imageView = findViewById<ImageView>(R.id.img)
        val redButton = findViewById<Button>(R.id.button)
        val greenButton = findViewById<Button>(R.id.button2)
        val blueButton = findViewById<Button>(R.id.button3)

        // Gestionnaire de clic pour le bouton rouge
        redButton.setOnClickListener {
            imageView.setImageResource(R.drawable.android_red)
        }

        // Gestionnaire de clic pour le bouton vert
        greenButton.setOnClickListener {
            imageView.setImageResource(R.drawable.android_green)
        }

        // Gestionnaire de clic pour le bouton bleu
        blueButton.setOnClickListener {
            imageView.setImageResource(R.drawable.android_blue)
        }
    }
}
