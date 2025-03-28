package com.example.frasesdodia

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView // propriedade para a classe, podendo ser usada varias vezes
    val frases = arrayOf(
        "O importante não é vencer todos os dias, mas lutar sempre.",
        "Maior que a tristeza de não haver vencido é a vergonha de não ter lutado.",
        "É melhor conquistar a si mesmo do que vencer mil batalhas.",
        "Enquanto houver vontade de lutar haverá esperança de vencer."
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        texto = findViewById(R.id.pressione_text) as TextView

        fun gerarFrase(view: View) {
            val totalIntensArray = frases.size
            val numeroAleatorio = Random.Default.nextInt(totalIntensArray)
            texto.setText(frases[numeroAleatorio])
        }

    }

    fun gerarFrase(view: View) {}


}