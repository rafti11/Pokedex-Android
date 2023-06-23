package com.example.pokedexapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonEntriesDTO(
    @SerializedName("entry_number")
    val id: Int,
    @SerializedName("pokemon_species")
    val pokemonSpecies: PokemonSpeciesDTO
)