package com.example.estudos.Telas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.estudos.MainActivity
import com.example.estudos.databinding.ActivityTela2Binding

class Tela2 : AppCompatActivity() {

    private lateinit var binding: ActivityTela2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTela2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        val emailUsuario = binding.emailUsuario
        val passwordUsuario = binding.passwordUsuario
        val botaoLogin = binding.btLogin


        binding.btLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }

}