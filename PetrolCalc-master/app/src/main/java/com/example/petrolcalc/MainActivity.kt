package com.example.petrolcalc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.petrolcalc.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


// Pegando referências dos elementos da interface
        val priceDieselEditText = findViewById<EditText>(R.id.text_disel_price)
        val priceGasolineEditText = findViewById<EditText>(R.id.text_gasoline_price)
        val resultTextView = findViewById<TextView>(R.id.resultado)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalc)


        // Evento de clique no botão
        buttonCalculate.setOnClickListener {
            val priceDiesel = priceDieselEditText.text.toString().toDoubleOrNull()
            val priceGasoline = priceGasolineEditText.text.toString().toDoubleOrNull()

            if (priceDiesel != null && priceGasoline != null) {
                if (priceDiesel < priceGasoline) {
                    resultTextView.text = "Diesel is more economical!"
                } else {
                    resultTextView.text = "Gasolina is more economical!"
                }
            } else {
                resultTextView.text = "Please enter valid values!"


            }

        }
    }
}