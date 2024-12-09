package com.example.exercice3

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var isLedOn = false // État initial de la LED (éteinte)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ledImage: ImageView = findViewById(R.id.ledImage)
        val toggleButton: ImageButton = findViewById(R.id.toggleButton)

        toggleButton.setOnClickListener {
            isLedOn = !isLedOn // Bascule l'état de la LED

            if (isLedOn) {
                // Allume la LED et change l'image du bouton
                ledImage.setImageResource(R.drawable.led_on)
                toggleButton.setImageResource(R.drawable.toggle_off)
            } else {
                // Éteint la LED et change l'image du bouton
                ledImage.setImageResource(R.drawable.led_off)
                toggleButton.setImageResource(R.drawable.toggle_on)
            }
        }
    }
}
