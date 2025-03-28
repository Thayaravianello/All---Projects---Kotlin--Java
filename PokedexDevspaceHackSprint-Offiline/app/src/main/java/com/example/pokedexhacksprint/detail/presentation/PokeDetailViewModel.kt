package com.example.pokedexhacksprint.detail.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.pokedexhacksprint.common.model.PokemonDto
import com.example.pokedexhacksprint.common.data.RetrofitClient
import com.example.pokedexhacksprint.detail.data.DetailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch




class PokeDetailViewModel(
    private val detailService: DetailService
): ViewModel() {

    private val _uiPoke = MutableStateFlow<PokemonDto?>(null)
    val uiPoke: StateFlow<PokemonDto?> = _uiPoke

    fun fetchMovieDetail(pokeName: String) {
        if (_uiPoke.value == null) {
            viewModelScope.launch(Dispatchers.IO) {
                val response = detailService.getPokemonByName(pokeName)
                if (response.isSuccessful){
                    _uiPoke.value = response.body()
                } else {
                    Log.d(
                        "MovieDetailViewModel",
                        "Request Error :: ${response.errorBody()}"
                    )
                }
            }
        }
    }

    fun cleanPokemonId() {

            _uiPoke.value = null

    }
    companion object {
        val Factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val detailService =
                    RetrofitClient.retrofitInstance.create(DetailService::class.java)
                return PokeDetailViewModel(
                    detailService
                ) as T
            }
        }
    }
}