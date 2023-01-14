package com.example.pifagor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagor.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    fun onClickAnswer(view: View){
       if(!onFailedEmpty()) {
           val result = getString(R.string.result_info) + getResult()
           bindingClass.edT.text = result
       }
    }

    private fun onFailedEmpty(): Boolean {
        bindingClass.apply {
            if (edA.text.isNullOrEmpty()) edA.error = "Введите число"
            if (edB.text.isNullOrEmpty()) edB.error = "Введите число"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()

        }
    }
    private fun getResult(): String{
        val a: Double
        val b: Double
        bindingClass.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
       return sqrt((a.pow(2) + b.pow(2))).toString()
    }
}