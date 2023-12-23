package com.csx4109.assignment

import android.app.Activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.csx4109.assignment.databinding.ActivityExampleAssignmentBinding


/**
 * Page Name: Counting Game
 *
 * -- Description --
 * Create an app that has
 * - textView named `tvCounter`
 * - button named `btnPlus`
 * - button named `btnMinus`
 *
 * Cases
 * - When open an application, the first value in `tvCounter` should be 0
 * - When click `btnPlus`, `tvCounter` should be increased by 1
 * - When click `btnMinus`, `tvCounter` should be decreased by 1
 */

class ExampleAssignmentActivity : AppCompatActivity() {
    private var counter = 0
    private lateinit var binding: ActivityExampleAssignmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set initial value in tvCounter
        updateCounterTextView()

        // Set click listeners for buttons
        binding.btnPlus.setOnClickListener {
            incrementCounter()
        }

        binding.btnMinus.setOnClickListener {
            decrementCounter()
        }
    }

    private fun updateCounterTextView() {
        binding.tvCounter.text = counter.toString()
    }

    private fun incrementCounter() {
        counter++
        updateCounterTextView()
    }

    private fun decrementCounter() {
        counter--
        updateCounterTextView()
    }
}
