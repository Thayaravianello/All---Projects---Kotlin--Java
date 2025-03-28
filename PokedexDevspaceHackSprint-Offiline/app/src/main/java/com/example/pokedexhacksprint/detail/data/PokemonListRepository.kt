package com.example.pokedexhacksprint.detail.data

import android.accounts.NetworkErrorException
import com.example.pokedexhacksprint.common.model.PokeResponse
import com.example.pokedexhacksprint.list.data.ListService
import com.example.pokedexhacksprint.list.presentation.ui.PokemonListUiState


class PokemonListRepository(
    private val listService: ListService
) {
    suspend fun getNowPokemon(): Result<PokeResponse?> {
        return try {
            val response = listService.getPokemons(limit = 20)
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(NetworkErrorException(response.message()))
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            Result.failure(ex)
        }
    }
}