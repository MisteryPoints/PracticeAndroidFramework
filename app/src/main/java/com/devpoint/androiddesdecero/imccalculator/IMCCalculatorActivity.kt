package com.devpoint.androiddesdecero.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.devpoint.androiddesdecero.R

class IMCCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = false
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

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
    }

    private fun initListeners(){
        viewMale.setOnClickListener{ setGenderColor() }
        viewFemale.setOnClickListener{ setGenderColor() }
    }

    private fun initUI(){
        setGenderColor()
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
}