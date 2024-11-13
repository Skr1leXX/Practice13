package com.example.trianglecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.practice13.R
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var sideAEditText: EditText
    private lateinit var sideBEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var triangleResultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sideAEditText = findViewById(R.id.sideAEditText)
        sideBEditText = findViewById(R.id.sideBEditText)
        calculateButton = findViewById(R.id.calculateButton)
        triangleResultTextView = findViewById(R.id.triangleResultTextView)


        calculateButton.setOnClickListener {
            calculateTriangle()
        }
    }

    private fun calculateTriangle() {
        val sideA = sideAEditText.text.toString()
        val sideB = sideBEditText.text.toString()

        // Проверка на пустые поля
        if (sideA.isEmpty() || sideB.isEmpty()) {
            Toast.makeText(this, "Введите длины катетов!", Toast.LENGTH_SHORT).show()
            return
        }

        val a = sideA.toDouble()
        val b = sideB.toDouble()


        val hypotenuse = sqrt(a * a + b * b)
        val perimeter = a + b + hypotenuse
        val area = 0.5 * a * b


        triangleResultTextView.text = String.format(
            "Гипотенуза: %.2f\nПериметр: %.2f\nПлощадь: %.2f",
            hypotenuse,
            perimeter,
            area
        )
    }
}