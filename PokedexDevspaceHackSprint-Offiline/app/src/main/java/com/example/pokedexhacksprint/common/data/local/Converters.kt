package com.example.pokedexhacksprint.common.data.local

import androidx.room.TypeConverter
import com.example.pokedexhacksprint.common.model.PokemonDto.StatSlot
import com.example.pokedexhacksprint.common.model.PokemonDto.TypeSlot
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromTypeSlotList(types: List<TypeSlot>?): String? {
        return gson.toJson(types)
    }

    @TypeConverter
    fun toTypeSlotList(typesString: String?): List<TypeSlot>? {
        val listType = object : TypeToken<List<TypeSlot>>() {}.type
        return gson.fromJson(typesString, listType)
    }

    @TypeConverter
    fun fromStatSlotList(stats: List<StatSlot>?): String? {
        return gson.toJson(stats)
    }

    @TypeConverter
    fun toStatSlotList(statsString: String?): List<StatSlot>? {
        val listType = object : TypeToken<List<StatSlot>>() {}.type
        return gson.fromJson(statsString, listType)
    }
}