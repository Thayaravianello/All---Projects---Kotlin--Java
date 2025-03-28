package com.example.jamiltondamascenostudy

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // aqui será escrito os códigos para dar vida ao designer


    }

    // entre as duas { vamos escrever

    // escrever função

    fun sortear(view: View) {
        var texto = findViewById(R.id.num_selecionado) as TextView

        //numero randomicos
            var numeroSorteado = Random().nextInt(61)

        texto.setText("Número sorteado é:  $numeroSorteado")


    }
}
