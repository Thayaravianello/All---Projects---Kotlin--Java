package com.example.devspaceapp1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)


        val result = intent.getFloatExtra(
            KEY_RESULT_IMC,0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        var classificacao: String? = null

        if (result <= 18.5F){
            classificacao = "MAGREZA"
        } else if (result > 18.5F && result <= 24.9F){
            classificacao = "NORMAL"
        }else if (result > 25F && result <= 29.9F){
            classificacao= "SOBREPESO"
        }else if (result > 30 && result <= 39.9F){
            classificacao = "OBESIDADE "
    }  else {
        classificacao ="OBESIDADE SEVERA"
        }

        tvClassificacao.text = classificacao
}
    }