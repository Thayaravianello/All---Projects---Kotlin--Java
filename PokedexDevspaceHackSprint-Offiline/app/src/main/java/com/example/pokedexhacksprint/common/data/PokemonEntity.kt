package com.example.pokedexhacksprint.common.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.pokedexhacksprint.common.model.PokemonDto
import com.example.pokedexhacksprint.common.data.local.Converters

@Entity(tableName = "pokemon_table")
@TypeConverters(Converters::class)
data class PokemonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val height: Double,
    val weight: Double,
    val types: List<PokemonDto.TypeSlot>,
    val stats: List<PokemonDto.StatSlot>,
    val frontDefault: String
)

fun PokemonDto.toPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        id = id,
        name = name,
        height = height.toDouble() / 10.0,
        weight = weight.toDouble() / 10.0,
        types = types,
        stats = stats,
        frontDefault = frontFullDefault
    )
}