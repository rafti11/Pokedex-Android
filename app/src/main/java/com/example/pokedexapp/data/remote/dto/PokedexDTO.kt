package com.example.pokedexapp.data.remote.dto

import com.example.pokedexapp.common.Tools
import com.example.pokedexapp.domain.model.Pokedex
import com.google.gson.annotations.SerializedName

data class PokedexDTO(
    @SerializedName("pokemon_entries")
    val entries: List<PokemonEntriesDTO>
)

fun PokedexDTO.toPokedex() : List<Pokedex>{
    val data: ArrayList<Pokedex> = ArrayList()
    entries.map {
//        val sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${it.id}.png"
        data.add(Pokedex(it.id, it.pokemonSpecies.name, Tools().getImageFromID(it.id)))
    }
    return data.toList()
}

