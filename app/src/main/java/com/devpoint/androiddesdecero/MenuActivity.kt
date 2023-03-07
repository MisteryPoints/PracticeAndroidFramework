package com.devpoint.androiddesdecero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.devpoint.androiddesdecero.firstapp.FirstAppActivity
import com.devpoint.androiddesdecero.imccalculator.IMCCalculatorActivity

class MenuActivity : AppCompatActivity() {
    val tag = "Main Activity"

    /*Primera funcion al Lanzar la Actividad*/
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(tag,"onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        btnSaludApp.setOnClickListener{
            navigateToSaludApp()
        }

        /*IMC = Indice de Masa Corporal*/
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnIMCApp.setOnClickListener {
            navigateToIMCApp()
        }

    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, IMCCalculatorActivity::class.java)
        startActivity(intent)
    }

    /*Funcion que se ejecuta al momento de reabrir la App*/
    override fun onStart() {
        Log.d(tag,"onStart")
        super.onStart()
    }

    /*Funcion que se ejecuta al tener la app en frente*/
    override fun onResume() {
        Log.d(tag,"onResume")
        super.onResume()
    }

    /*Funcion que se ejecuta al poner algo enfrente de la app*/
    override fun onPause() {
        Log.d(tag,"onPause")
        super.onPause()
    }

    /*Funcion que se ejecuta al minimizar la app o cambiar a otra app*/
    override fun onStop() {
        Log.d(tag,"onStop")
        super.onStop()
    }

    /*Ultima funcion al cerrarse la Actividad*/
    override fun onDestroy() {
        Log.d(tag,"onDestroy")
        super.onDestroy()
    }
}