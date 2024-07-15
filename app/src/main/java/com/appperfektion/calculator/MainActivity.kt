package com.appperfektion.calculator

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appperfektion.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    var number: String? = null

    var firstNumber: Double = 0.0
    var lastNumber: Double = 0.0

    var status: String? = null
    var operator: Boolean = false

    val myFormatter = DecimalFormat("######.######")

    var history: String = ""
    var currentResult: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.textViewResult.text = "0"

        mainBinding.btnZero.setOnClickListener {
            onNumberClicked("0")
        }

        mainBinding.btnOne.setOnClickListener {
            onNumberClicked("1")
        }

        mainBinding.btnTwo.setOnClickListener {
            onNumberClicked("2")
        }

        mainBinding.btnThree.setOnClickListener {
            onNumberClicked("3")
        }

        mainBinding.btnFour.setOnClickListener {
            onNumberClicked("4")
        }

        mainBinding.btnFive.setOnClickListener {
            onNumberClicked("5")
        }

        mainBinding.btnSix.setOnClickListener {
            onNumberClicked("6")
        }

        mainBinding.btnSeven.setOnClickListener {
            onNumberClicked("7")
        }

        mainBinding.btnEight.setOnClickListener {
            onNumberClicked("8")
        }

        mainBinding.btnNine.setOnClickListener {
            onNumberClicked("9")
        }


        mainBinding.btnAC.setOnClickListener {
            onButtonACClicked()
        }

        mainBinding.btnDel.setOnClickListener {
            number?.let{
                number = it.substring(0,it.length-1)
                mainBinding.textViewResult.text = number
            }
        }

        mainBinding.btnDivider.setOnClickListener {
            history = mainBinding.textViewHistory.text.toString()
            currentResult = mainBinding.textViewResult.text.toString()
            mainBinding.textViewHistory.text = history.plus(currentResult).plus("/")
            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
            }
            status = "division"
            operator = false
            number = null
        }

        mainBinding.btnMulti.setOnClickListener {
            history = mainBinding.textViewHistory.text.toString()
            currentResult = mainBinding.textViewResult.text.toString()
            mainBinding.textViewHistory.text = history.plus(currentResult).plus("*")
            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
            }
            status = "multiplication"
            operator = false
            number = null
        }

        mainBinding.btnMinus.setOnClickListener {
            history = mainBinding.textViewHistory.text.toString()
            currentResult = mainBinding.textViewResult.text.toString()
            mainBinding.textViewHistory.text = history.plus(currentResult).plus("-")
            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
            }
            status = "substraction"
            operator = false
            number = null
        }

        mainBinding.btnPlus.setOnClickListener {
            history = mainBinding.textViewHistory.text.toString()
            currentResult = mainBinding.textViewResult.text.toString()
            mainBinding.textViewHistory.text = history.plus(currentResult).plus("+")
            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
            }
            status = "addition"
            operator = false
            number = null
        }

        mainBinding.btnEqual.setOnClickListener {
            history = mainBinding.textViewHistory.text.toString()
            currentResult = mainBinding.textViewResult.text.toString()
            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
                mainBinding.textViewHistory.text = history.plus(currentResult).plus("=").plus(mainBinding.textViewResult.text.toString())
            }
            operator = false
        }

        mainBinding.btnDot.setOnClickListener {
            number = if (number == null){
                "0."
            } else {
                "$number."
            }
        }
        mainBinding.textViewResult.text = number

    }

    fun onButtonACClicked(){
        number = null
        status = null
        mainBinding.textViewResult.text = "0"
        mainBinding.textViewHistory.text = ""
        firstNumber = 0.0
        lastNumber = 0.0
    }

    fun onNumberClicked(clickedNumber: String){
        if (number == null){
            number = clickedNumber
        } else {
            number += clickedNumber
        }
        mainBinding.textViewResult.text = number
        operator = true
    }

    fun plus(){
        lastNumber = mainBinding.textViewResult.text.toString().toDouble()
        firstNumber += lastNumber
        mainBinding.textViewResult.text = myFormatter.format(firstNumber)
    }

    fun minus(){
        lastNumber = mainBinding.textViewResult.text.toString().toDouble()
        firstNumber -= lastNumber
        mainBinding.textViewResult.text = myFormatter.format(firstNumber)
    }

    fun multiply(){
        lastNumber = mainBinding.textViewResult.text.toString().toDouble()
        firstNumber *= lastNumber
        mainBinding.textViewResult.text = myFormatter.format(firstNumber)
    }

    fun divide() {
        lastNumber = mainBinding.textViewResult.text.toString().toDouble()
        if (lastNumber == 0.0) {
            Toast.makeText(applicationContext, "The divisor cannot be zero.", Toast.LENGTH_LONG)
                .show()
        } else {
            firstNumber /= lastNumber
            mainBinding.textViewResult.text = myFormatter.format(firstNumber)
        }
    }
}