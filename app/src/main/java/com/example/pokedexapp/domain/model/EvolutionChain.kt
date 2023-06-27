package com.example.pokedexapp.domain.model

data class EvolutionChain (
    val name: String,
    val evolves: List<String> = emptyList()
)

data class PokemonEvolution(
    val name: String,
    val evolvesTo: List<EvolutionChain2>
)

data class EvolutionChain2 (
    val name: String,
    val evolves: List<EvolutionChain2> = emptyList()
)