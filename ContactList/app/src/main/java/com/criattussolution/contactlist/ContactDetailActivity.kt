package com.criattussolution.contactlist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_detail)



        val tvName = findViewById<TextView>(R.id.nome_detail)
        val tvPhone = findViewById<TextView>(R.id.number_detail)
        val tvImage = findViewById<ImageView>(R.id.img_tela_detail)
        val share = findViewById<TextView>(R.id.Share_contact)

            val nome = intent.getStringExtra("nome")
            val telefone = intent.getStringExtra("telefone")
            val imagem = intent.getIntExtra("imagem", R.drawable.sample1)

        val returnIcon = findViewById<ImageView>(R.id.return_icon)


        tvName.text = nome
        tvPhone.text = telefone
        tvImage.setImageResource(imagem)

// COLOCAR ACHAR DE CLICQUE NO BOTAO SHARE

        share.setOnClickListener {
            //COMPARTILHAR AS ACAOES DO CONTAT
            //INTENT IMPLICITA

            val sendIntent: Intent  = Intent()
                .apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "$nome $telefone")
                    type="text/plain"
                }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        returnIcon.setOnClickListener {
            finish()
        }


    }
}