package com.example.pokedexapp.data.remote.dto

import com.example.pokedexapp.common.Tools
import com.example.pokedexapp.domain.model.Pokedex
import com.example.pokedexapp.domain.model.PokedexEntry
import com.google.gson.annotations.SerializedName

data class PokedexListDTO(
    @SerializedName("data")
    val pokemonV2: PokemonV2
)

data class PokemonV2(
    @SerializedName("pokemon_v2_pokemon")
    val pokemons: List<Pokemon>
)

data class Pokemon(
    val id: Int,
    val name: String,
    @SerializedName("types")
    val types: List<PokemonType>
)

data class PokemonType(
    @SerializedName("type")
    val pType: PType
)

data class PType(
    val name: String
)

fun PokedexListDTO.toPokemonEntryList() : List<PokedexEntry> {
    val data: ArrayList<PokedexEntry> = ArrayList()
    pokemonV2.pokemons.map { pok ->
        data.add(PokedexEntry(
            id = pok.id,
            name = pok.name,
            image = Tools().getImageFromID(pok.id),
            types = pok.types.map { it.pType.name }))
    }
    return data
}