package com.example.pokedexhacksprint.common.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedexhacksprint.common.data.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonNowDao {
    @Query("SELECT * FROM pokemon_table ORDER BY id ASC")
    fun getPokemonList(): Flow<List<PokemonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonList: List<PokemonEntity>)

    @Query("DELETE FROM pokemon_table")
    suspend fun clearPokemonTable()
}