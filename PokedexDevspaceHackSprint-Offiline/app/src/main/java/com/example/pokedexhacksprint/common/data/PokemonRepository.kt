package com.example.pokedexhacksprint.common.data

import android.Manifest
import android.content.Context
import android.util.Log
import androidx.annotation.RequiresPermission
import com.example.pokedexhacksprint.common.data.local.PokemonNowDao
import kotlinx.coroutines.flow.Flow

class PokemonRepository(
    private val apiService: PokedexApi,
    private val pokemonDao: PokemonNowDao,
    private val networkUtils: NetworkUtils,
    private val context: Context
) {
    val pokemons: Flow<List<PokemonEntity>> = pokemonDao.getPokemonList()

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    suspend fun syncPokemons() {
        try {
            if (networkUtils.isNetworkAvailable(context)) {
                val listResponse = apiService.getPokemonList()
                if (listResponse.isSuccessful) {
                    val pokemonListItems = listResponse.body()?.results ?: emptyList()
                    val pokemonEntities = mutableListOf<PokemonEntity>()
                    for (item in pokemonListItems) {
                        val detailResponse = apiService.getPokemonByName(item.name)
                        if (detailResponse.isSuccessful) {
                            detailResponse.body()?.toPokemonEntity()?.let { pokemonEntities.add(it) }
                        } else {
                            Log.e("PokemonRepository", "Erro ao buscar detalhes de ${item.name}: ${detailResponse.message()}")
                        }
                    }
                    pokemonDao.clearPokemonTable()
                    pokemonDao.insertAll(pokemonEntities)
                } else {
                    Log.e("PokemonRepository", "Erro na resposta da lista: ${listResponse.message()}")
                }
            } else {
                Log.i("PokemonRepository", "Sem conexão, usando dados locais")
            }
        } catch (e: Exception) {
            Log.e("PokemonRepository", "Erro ao sincronizar dados", e)
        }
    }
}