package com.example.pokedexhacksprint.common.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokedexhacksprint.common.data.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PokemonNowDataBase : RoomDatabase() {
    abstract fun pokemonNowDao(): PokemonNowDao
}