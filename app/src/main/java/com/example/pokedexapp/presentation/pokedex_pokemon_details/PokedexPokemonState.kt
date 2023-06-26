package com.example.pokedexapp.presentation.pokedex_pokemon_details

import com.example.pokedexapp.domain.model.Pokedex
import com.example.pokedexapp.domain.model.PokedexEntry
import com.example.pokedexapp.domain.model.Pokemon
import com.example.pokedexapp.domain.model.Stats

data class PokedexPokemonState(
    val isLoading: Boolean = false,
    val pokemon: Pokemon = Pokemon(1, "default", 1, 1, "", listOf("grass"), Stats(1, 1, 1, 1, 1, 1)),
    val error: String = ""
)