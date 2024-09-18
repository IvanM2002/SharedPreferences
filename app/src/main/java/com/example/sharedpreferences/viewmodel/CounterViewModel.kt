package com.example.sharedpreferences.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> = _counter

    init {
        loadCounter()
    }

    private fun loadCounter() {
        val currentCounter = sharedPreferences.getInt("counter", 0)
        _counter.value = currentCounter
    }

    fun incrementCounter() {
        val newCounterValue = (_counter.value ?: 0) + 1
        _counter.value = newCounterValue
        sharedPreferences.edit().putInt("counter", newCounterValue).apply()
    }
}