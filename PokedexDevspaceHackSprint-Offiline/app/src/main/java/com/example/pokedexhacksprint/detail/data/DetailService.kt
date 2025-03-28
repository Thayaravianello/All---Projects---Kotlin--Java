package com.example.pokedexhacksprint.detail.data

import com.example.pokedexhacksprint.common.model.PokemonDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {
    @GET("pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") name: String): Response<PokemonDto>
}