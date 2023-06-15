package com.example.pokedexapp.data.remote

import com.example.pokedexapp.domain.model.Pokedex
import com.google.gson.annotations.SerializedName

data class PokedexDTO(
    @SerializedName("pokemon_entries")
    val entries: List<PokemonEntriesDTO>
)

fun PokedexDTO.toPokedex() : List<Pokedex>{
    val national: ArrayList<Pokedex> = ArrayList()
    entries.map {
        val sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${it.id}.png"
        national.add(Pokedex(it.id, it.pokemonSpecies.name, sprite))
    }
    return national.toList()
}