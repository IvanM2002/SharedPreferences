package com.example.sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var counterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencia al TextView
        counterTextView = findViewById(R.id.counterTextView)

        // Obtener el valor del contador desde SharedPreferences
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val counter = sharedPreferences.getInt("counter", 0)

        // Incrementar el valor
        val newCounterValue = counter + 1

        // Mostrar el valor actualizado en el TextView
        counterTextView.text = newCounterValue.toString()

        // Guardar el nuevo valor en SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putInt("counter", newCounterValue)
        editor.apply()
    }
}