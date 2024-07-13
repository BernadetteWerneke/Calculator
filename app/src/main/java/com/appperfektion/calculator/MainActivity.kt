package com.appperfektion.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appperfektion.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    var number: String? = null

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

        }

        mainBinding.btnDel.setOnClickListener {

        }

        mainBinding.btnDivider.setOnClickListener {

        }

        mainBinding.btnMulti.setOnClickListener {

        }

        mainBinding.btnMinus.setOnClickListener {

        }

        mainBinding.btnPlus.setOnClickListener {

        }

        mainBinding.btnEqual.setOnClickListener {

        }

        mainBinding.btnDot.setOnClickListener {

        }

    }

    private fun onNumberClicked(clickedNumber: String){
        if (number == null){
            number = clickedNumber
        } else {
            number += clickedNumber
        }
        mainBinding.textViewResult.text = number
    }

    fun plus(){

    }
}