package com.example.pokedexapp.data.remote

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesDTO(
    @SerializedName("name")
    val name: String
)