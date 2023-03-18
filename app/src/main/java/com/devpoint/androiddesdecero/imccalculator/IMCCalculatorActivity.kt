package com.devpoint.androiddesdecero.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.devpoint.androiddesdecero.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import org.w3c.dom.Text
import java.text.DecimalFormat

class IMCCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 0
    private var currentAge: Int = 0
    private var currentHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnMinusWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnMinusAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnMinusWeight = findViewById(R.id.btnMinusWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnMinusAge = findViewById(R.id.btnMinusAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
        setAge()
        setWeight()
    }

    private fun initListeners(){
        viewMale.setOnClickListener{
            changeGender("male")
            setGenderColor()
        }
        viewFemale.setOnClickListener{
            changeGender("female")
            setGenderColor()
        }
        rsHeight.addOnChangeListener{ _, value, _ ->
            /*El patron hace que lo que este en # y no esté usandose se corrija eliminandose*/
            val df = DecimalFormat("#.## cm")
            val result = df.format(value)
            currentHeight = value.toInt()
            tvHeight.text = result
        }
        btnMinusWeight.setOnClickListener{
            if(currentWeight != 0) {
                currentWeight -= 1
                setWeight()
            }
        }
        btnPlusWeight.setOnClickListener{
            if(currentWeight != 300) {
                currentWeight += 1
                setWeight()
            }
        }
        btnMinusAge.setOnClickListener{
            if(currentAge != 0){
                currentAge -= 1
                setAge()
            }
        }
        btnPlusAge.setOnClickListener{
            if(currentAge != 100) {
                currentAge += 1
                setAge()
            }
        }
        btnCalculate.setOnClickListener{
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun initUI(){
        setGenderColor()
    }

    private fun changeGender(gender: String){
        when(gender){
            "male" -> {
                if(isMaleSelected) return
                isMaleSelected = true
                isFemaleSelected = false
            }

            "female" -> {
                if(isFemaleSelected) return
                isFemaleSelected = true
                isMaleSelected = false
            }
        }
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isCardSelected: Boolean): Int{
        val colorReference = if(isCardSelected){
            R.color.bg_component_selected
        } else {
            R.color.bg_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity:: class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

}