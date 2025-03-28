package com.example.estudos.Telas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.estudos.databinding.ActivityAlbumFotoUnicaBinding

class AlbumFotoUnica : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumFotoUnicaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumFotoUnicaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val tituloNomeAlbum = binding.titleNomeAlbum
        val imagemDetalhe = binding.imgGrande
        val botaoVoltar = binding.btVoltar
        val botaoProximo = binding.btProximo


        }
    }