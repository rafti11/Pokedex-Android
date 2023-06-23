package com.example.pokedexapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesDTO(
    @SerializedName("name")
    val name: String
)