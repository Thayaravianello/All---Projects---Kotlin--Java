package com.example.project3

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project3.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // VALOR INICIAL DA PORCENTAGEM

        var percentage: Int = 0

        // BINDING - BOTOES DE PORCENTAGEM


        binding.buttonPerctOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                percentage = 10
        }

        binding.buttonPorcTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                percentage = 15
        }

        binding.buttonPerctThree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                percentage = 20
        }

        // BINDING -BOTOES LIMPAR E CALCULAR


        binding.btnCalculator.setOnClickListener {

            // EVITAR BUG COM CAMPOS LIMPOS

            val totalTemp = binding.totalConta.text
            val numeroPessoasTempe = binding.totalPessoas.text

            if (totalTemp?.isEmpty() == true|| numeroPessoasTempe?.isEmpty() == true) {
                    Snackbar.make( binding.totalConta , "Preencha todos os campos", Snackbar.LENGTH_LONG)
                        .show()

            }else{

                // BINDING DAS TEXTVIEWS

                val totalFinal : Float = totalTemp.toString().toFloat()
                val numeroPessoas : Int = numeroPessoasTempe.toString().toInt()

                // calulando a gorjeta

                val totalSemPorcentagem = totalFinal / numeroPessoas
                val  totalComPorcentagem = totalSemPorcentagem * percentage/100
                val valorFinalCliente = totalComPorcentagem + totalSemPorcentagem

                binding.resultadoTela.text =  "Total por pessoa : $valorFinalCliente"


            }

        }

        binding.btnLimpar.setOnClickListener{
            binding.resultadoTela.text=""
            binding.totalConta.setText("")
            binding.totalPessoas.setText("")
            binding.buttonPerctOne.isChecked =false
            binding.buttonPerctThree.isChecked =false
            binding.buttonPorcTwo.isChecked =false


        }

    }
    }
