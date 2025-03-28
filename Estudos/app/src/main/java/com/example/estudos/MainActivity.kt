package com.example.estudos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudos.Telas.AlbumFotoUnica
import com.example.estudos.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)




        // chamar as ids do projeto dessa XML

        val titleHeaderLogin = binding.titleHeaderName
        val imageOne = binding.imgOne
        val imageTwo = binding.imgTwo
        val imageThree = binding.imgThree
        val imageFour = binding.imgFour
        val albumTitle = binding.albumTitle
        val btFotos = binding.btMaisFotos
        val fotoOne = binding.imgOne
        val fotoTwo = binding.imgTwo
        val fotoThree = binding.imgThree
        val fotoFour = binding.imgFour



        binding.imgThree.setOnClickListener {
            val intent = Intent(this, AlbumFotoUnica::class.java)
            startActivity(intent)


        }

    }




}










