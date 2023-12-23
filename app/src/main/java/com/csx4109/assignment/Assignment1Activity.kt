package com.csx4109.assignment

/**
 * Page Name: Basic Calculator
 *
 * -- Description --
 * Create an app can do basic calculation, consists of
 * - textView named `tvResult`
 * - button of number 0-9 named `btn0` - `btn9`
 * - button named `btnPlus`
 * - button named `btnEqual`
 * - button named `btnClear`
 *
 * Cases
 * - When open an application, the first value in `tvResult` should be 0
 * - When type any number button and `btnPlus`, value on `tvResult` should be updated
 * - When click `btnEqual`, value on `tvResult` should updated to be the result of your calculation
 * - After click `btnEqual` to calculate the result, you should be able to type more number for further calculation
 * - When click `btnClear`, value on `tvResult` should return to 0
 */

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Assignment1Activity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private var currentInput: String = ""
    private var currentResult: Int = 0
    private var lastOperator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a vertical LinearLayout
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        setContentView(layout)

        // Initialize UI elements
        tvResult = TextView(this)
        tvResult.text = "0"
        tvResult.textSize = 24f
        layout.addView(tvResult)

        // Create number buttons (0-9)
        for (i in 0..9) {
            val button = Button(this)
            button.text = i.toString()
            button.setOnClickListener { onNumberButtonClick(i) }
            layout.addView(button)
        }

        // Create operator buttons
        val btnPlus = Button(this)
        btnPlus.text = "+"
        btnPlus.setOnClickListener { onOperatorButtonClick("+") }
        layout.addView(btnPlus)

        // Create equal button
        val btnEqual = Button(this)
        btnEqual.text = "="
        btnEqual.setOnClickListener { calculateResult() }
        layout.addView(btnEqual)

        // Create clear button
        val btnClear = Button(this)
        btnClear.text = "Clear"
        btnClear.setOnClickListener { clearCalculator() }
        layout.addView(btnClear)
    }

    private fun onNumberButtonClick(number: Int) {
        currentInput += number
        updateResultText()
    }

    private fun onOperatorButtonClick(operator: String) {
        if (currentInput.isNotEmpty()) {
            lastOperator = operator
            currentResult += currentInput.toInt()
            currentInput = ""
            updateResultText()
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty()) {
            currentResult += currentInput.toInt()
            currentInput = ""
            updateResultText()
        }
    }

    private fun clearCalculator() {
        currentInput = ""
        currentResult = 0
        lastOperator = ""
        updateResultText()
    }

    private fun updateResultText() {
        tvResult.text = if (currentInput.isNotEmpty()) currentInput else currentResult.toString()
    }
}