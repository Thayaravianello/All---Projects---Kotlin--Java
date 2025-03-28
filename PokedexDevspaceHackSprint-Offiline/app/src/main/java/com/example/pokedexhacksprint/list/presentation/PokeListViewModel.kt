package com.example.pokedexhacksprint.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.pokedexhacksprint.PokemonNowApplication
import com.example.pokedexhacksprint.common.data.NetworkUtils
import com.example.pokedexhacksprint.common.data.PokedexApi
import com.example.pokedexhacksprint.common.data.PokemonRepository
import com.example.pokedexhacksprint.common.data.RetrofitClient
import com.example.pokedexhacksprint.common.model.PokemonDto
import com.example.pokedexhacksprint.list.presentation.ui.PokemonListUiState
import com.example.pokedexhacksprint.list.presentation.ui.PokemonUiData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PokeListViewModel(
    private val repository: PokemonRepository
) : ViewModel() {
    private val _uiPokemons = MutableStateFlow<PokemonListUiState>(PokemonListUiState())
    val uiPokemons: StateFlow<PokemonListUiState> = _uiPokemons

    private val _searchError = MutableStateFlow<String?>(null)
    val searchError: StateFlow<String?> = _searchError

    private var isSearching = false

    init {
        observeLocalData()
        syncWithApi()
    }

    private fun observeLocalData() {
        viewModelScope.launch {
            repository.pokemons.collectLatest { pokemonList ->
                _uiPokemons.value = PokemonListUiState(
                    list = pokemonList.map {
                        PokemonUiData(
                            id = it.id,
                            name = it.name,
                            url = null,
                            height = it.height.toInt(),
                            weight = it.weight.toInt(),
                            types = it.types,
                            stats = it.stats,
                            sprites = PokemonDto.Sprites(it.frontDefault),
                            frontFullDefault = it.frontDefault
                        )
                    }
                )
            }
        }
    }

    fun syncWithApi() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.syncPokemons()
        }
    }

    fun searchPokemon(query: String) {
        if (query.isEmpty()) {
            isSearching = false
            _searchError.value = null
            observeLocalData()
        } else {
            isSearching = true
            val filteredPokemons = _uiPokemons.value.list.filter {
                it.name.contains(query, ignoreCase = true)
            }
            if (filteredPokemons.isNotEmpty()) {
                _uiPokemons.value = PokemonListUiState(list = filteredPokemons)
                _searchError.value = null
            } else {
                _searchError.value = "Nenhum Pokémon encontrado"
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokemonNowApplication
                val apiService = RetrofitClient.retrofitInstance.create(PokedexApi::class.java)
                val repository = PokemonRepository(
                    apiService,
                    application.pokemonDao,
                    NetworkUtils,
                    application // Passa o Context (Application) aqui
                )
                return PokeListViewModel(repository) as T
            }
        }
    }
}