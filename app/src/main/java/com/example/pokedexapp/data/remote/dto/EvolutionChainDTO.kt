package com.example.pokedexapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class EvolutionChainDTO(
    val chain: Chain
)

data class Chain(
    @SerializedName("evolves_to")
    val evolvesTo: List<Chain>,
    val species: Species,
    @SerializedName("is_baby")
    val isBaby: Boolean
)

data class Species(
    val name: String,
    val url: String
)