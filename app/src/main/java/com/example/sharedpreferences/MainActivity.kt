package com.example.sharedpreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.sharedpreferences.viewmodel.CounterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var counterTextView: TextView

    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterTextView = findViewById(R.id.counterTextView)

        counterViewModel.counter.observe(this, Observer { counter ->
            counterTextView.text = counter.toString()
        })

        counterViewModel.incrementCounter()
    }
}