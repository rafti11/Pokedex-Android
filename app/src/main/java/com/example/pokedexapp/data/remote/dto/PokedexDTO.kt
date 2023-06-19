package com.example.pokedexapp.data.remote.dto

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
        data.add(Pokedex(it.id, it.pokemonSpecies.name, getImageFromID(it.id)))
    }
    return data.toList()
}

private fun getImageFromID(id: Int) : String{

    val url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/"
    val extension = ".png"

    return when(id){
        in 1..9 -> url + "00" + id + extension
        in 10..99 -> url + "0" + id + extension
        else -> url + id + extension
    }
}