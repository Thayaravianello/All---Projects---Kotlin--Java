package com.example.pokedexhacksprint.common.model

data class PokeResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonDto>,
)

