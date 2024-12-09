package com.example.calculatrice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextResult: EditText
    private var currentInput: String = ""
    private var operator: String? = null
    private var firstOperand: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation des vues
        editTextResult = findViewById(R.id.editTextResult)

        // Boutons numériques
        val buttonsNumbers = listOf(
            findViewById<Button>(R.id.button0),
            findViewById<Button>(R.id.button1),
            findViewById<Button>(R.id.button2),
            findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button4),
            findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button9)
        )

        buttonsNumbers.forEachIndexed { index, button ->
            button.setOnClickListener {
                appendToInput(index.toString())
            }
        }

        // Bouton AC (Clear)
        findViewById<Button>(R.id.buttonAC).setOnClickListener {
            clearAll()
        }

        // Bouton point (.)
        findViewById<Button>(R.id.buttonPoint).setOnClickListener {
            if (!currentInput.contains(".")) {
                appendToInput(".")
            }
        }

        // Opérations
        findViewById<Button>(R.id.buttonAddition).setOnClickListener { setOperator("+") }
        findViewById<Button>(R.id.buttonSoustraction).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.buttonMultiplication).setOnClickListener { setOperator("*") }
        findViewById<Button>(R.id.buttonDivision).setOnClickListener { setOperator("/") }

        // Bouton égal
        findViewById<Button>(R.id.buttonEqual).setOnClickListener {
            calculateResult()
        }
    }

    private fun appendToInput(value: String) {
        currentInput += value
        editTextResult.setText(currentInput)
    }

    private fun clearAll() {
        currentInput = ""
        operator = null
        firstOperand = null
        editTextResult.setText("0")
    }

    private fun setOperator(selectedOperator: String) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDoubleOrNull()
            operator = selectedOperator
            currentInput = ""
        }
    }

    private fun calculateResult() {
        if (firstOperand != null && operator != null && currentInput.isNotEmpty()) {
            val secondOperand = currentInput.toDoubleOrNull()
            if (secondOperand != null) {
                val result = when (operator) {
                    "+" -> firstOperand!! + secondOperand
                    "-" -> firstOperand!! - secondOperand
                    "*" -> firstOperand!! * secondOperand
                    "/" -> if (secondOperand != 0.0) firstOperand!! / secondOperand else "Erreur"
                    else -> "Erreur"
                }
                editTextResult.setText(result.toString())
                // Réinitialiser les valeurs
                firstOperand = null
                operator = null
                currentInput = ""
            }
        }
    }
}
