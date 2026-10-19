package com.example.simplecalculatorwithhistory

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.iterator

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private lateinit var rvHistory: RecyclerView
    private val historyList = mutableListOf<String>()
    private lateinit var historyAdapter: HistoryAdapter

    private var currentInput = ""
    private var firstNum = 0.0
    private var currentOperator = ' '
    private var isNewOp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)
        rvHistory = findViewById(R.id.rvHistory)

        // Setup History RecyclerView
        historyAdapter = HistoryAdapter(historyList)
        rvHistory.layoutManager = LinearLayoutManager(this).apply {
            stackFromEnd = true // Keeps newer history items flowing nicely
        }
        rvHistory.adapter = historyAdapter

        setupNumberButtons()
        setupOperatorButtons()
    }

    private fun setupNumberButtons() {
        val numberButtons = mapOf(
            R.id.btn0 to "0",
            R.id.btnDoubleZero to "00",
            R.id.btn1 to "1",
            R.id.btn2 to "2",
            R.id.btn3 to "3",
            R.id.btn4 to "4",
            R.id.btn5 to "5",
            R.id.btn6 to "6",
            R.id.btn7 to "7",
            R.id.btn8 to "8",
            R.id.btn9 to "9",
            R.id.btnDot to "."
        )

        for ((id, value) in numberButtons) {
            findViewById<Button>(id).setOnClickListener {
                if (isNewOp) {
                    currentInput = ""
                    isNewOp = false
                }
                if (value == "." && currentInput.contains(".")) return@setOnClickListener
                currentInput += value
                tvDisplay.text = currentInput
            }
        }
    }

    private fun setupOperatorButtons() {
        findViewById<Button>(R.id.btnAC).setOnClickListener {
            currentInput = ""
            firstNum = 0.0
            currentOperator = ' '
            tvDisplay.text = "0"
            isNewOp = true
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                currentInput = currentInput.dropLast(1)
                tvDisplay.text = if (currentInput.isEmpty()) "0" else currentInput
            }
        }

        val operators = mapOf(
            R.id.btnPlus to '+',
            R.id.btnMinus to '-',
            R.id.btnMultiply to '×',
            R.id.btnDivide to '÷'
        )

        for ((id, op) in operators) {
            findViewById<Button>(id).setOnClickListener {
                if (currentInput.isNotEmpty()) {
                    firstNum = currentInput.toDouble()
                    currentOperator = op
                    isNewOp = true
                }
            }
        }

        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            if (currentInput.isNotEmpty() && currentOperator != ' ') {
                val secondNum = currentInput.toDouble()
                var result = 0.0

                when (currentOperator) {
                    '+' -> result = firstNum + secondNum
                    '-' -> result = firstNum - secondNum
                    '×' -> result = firstNum * secondNum
                    '÷' -> if (secondNum != 0.0) result = firstNum / secondNum else {
                        tvDisplay.text = "Error"
                        return@setOnClickListener
                    }
                }

                val formattedResult = if (result % 1.0 == 0.0) result.toInt().toString() else result.toString()
                val calculation = "$firstNum $currentOperator $secondNum = $formattedResult"

                historyList.add(calculation)
                historyAdapter.notifyItemInserted(historyList.size - 1)
                rvHistory.scrollToPosition(historyList.size - 1)

                tvDisplay.text = formattedResult
                currentInput = formattedResult
                isNewOp = true
                currentOperator = ' '
            }
        }
    }
}