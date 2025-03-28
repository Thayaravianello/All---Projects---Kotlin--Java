package com.example.devspaceapp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.devspaceapp1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main) //

        val edtPeso = findViewById<TextInputEditText>(R.id.edtpeso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edtaltura)
        val btnCalcular = findViewById<Button>(R.id.btncalcular)

        btnCalcular.setOnClickListener {

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            // se o usuario nao preencher para evitar bug cria-se a snackbar


            if (pesoStr == "" || alturaStr == "") {
                Snackbar.make(
                    edtPeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            } else {
                val peso: Float = edtPeso.text.toString().toFloat()
                val altura: Float = edtAltura.text.toString().toFloat()
                val resultadoAltura = (altura * altura)
                val resultadoImc = peso / resultadoAltura


                // criar nova tela
                val intent = Intent(this, ResultActivity::class.java)
               intent.putExtra( KEY_RESULT_IMC, resultadoImc)
                startActivity(intent)

                println("Seu imc é " + resultadoImc)

            }
        }
    }
}

