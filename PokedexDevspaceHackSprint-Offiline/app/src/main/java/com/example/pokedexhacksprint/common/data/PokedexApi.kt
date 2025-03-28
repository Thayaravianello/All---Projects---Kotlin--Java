package com.example.pokedexhacksprint.common.data


import com.example.pokedexhacksprint.common.model.PokemonDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApi {

    @GET("pokemon?limit=151")
    suspend fun getPokemonList(): Response<PokemonListResponse>

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): Response<PokemonDto>
}

data class PokemonListResponse(
    val results: List<com.example.pokedexhacksprint.common.model.PokemonListItemDto>
)
