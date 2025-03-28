package com.example.pokedexhacksprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.pokedexhacksprint.detail.presentation.PokeDetailViewModel
import com.example.pokedexhacksprint.list.presentation.PokeListViewModel
import com.example.pokedexhacksprint.ui.theme.PokedexHackSprintTheme

class MainActivity : ComponentActivity() {
    private val listViewModel by viewModels<PokeListViewModel> { PokeListViewModel.Factory }
    private val detailViewModel by viewModels<PokeDetailViewModel> { PokeDetailViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexHackSprintTheme {
                androidx.compose.material3.Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.white)
                ) {
                    PokedexApp(
                        listViewModel = listViewModel,
                        detailViewModel = detailViewModel
                    )
                }
            }
        }
    }
}