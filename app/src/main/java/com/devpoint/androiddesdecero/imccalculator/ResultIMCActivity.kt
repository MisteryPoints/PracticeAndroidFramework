package com.devpoint.androiddesdecero.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.devpoint.androiddesdecero.R
import com.devpoint.androiddesdecero.imccalculator.IMCCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initListeners()
        initUI(result)
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00 .. 18.50 -> { //Bajo Peso
                tvResult.text = getString(R.string.bajopeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.pesobajo))
                tvDescription.text = getString(R.string.descripcionbajopeso)
            }
            in 18.51 .. 24.99 -> { //Normal
                tvResult.text = getString(R.string.normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.pesonormal))
                tvDescription.text = getString(R.string.descripcionnormal)
            }
            in 25.00 .. 29.99 -> { //Sobrepeso
                tvResult.text = getString(R.string.sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                tvDescription.text = getString(R.string.descripcionsobrepeso)
            }
            in 30.00 .. 99.00 -> { //Obesidad
                tvResult.text = getString(R.string.obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescription.text = getString(R.string.descripcionobesidad)
            }
            else -> { //Error
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvIMC.text = getString(R.string.error)
                tvIMC.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescription.text = getString(R.string.error)
                tvDescription.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
            }
        }
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener {  onBackPressed() }
    }
}