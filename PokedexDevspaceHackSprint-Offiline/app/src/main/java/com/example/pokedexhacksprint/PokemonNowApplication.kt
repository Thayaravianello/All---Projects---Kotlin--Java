package com.example.pokedexhacksprint

import android.app.Application
import androidx.room.Room
import com.example.pokedexhacksprint.common.data.local.PokemonNowDataBase

class PokemonNowApplication : Application() {
    val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            PokemonNowDataBase::class.java, "database-pokemon-now"
        ).build()
    }

    val pokemonDao by lazy { db.pokemonNowDao() }
}