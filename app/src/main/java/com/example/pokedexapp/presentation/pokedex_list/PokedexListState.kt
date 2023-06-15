package com.example.pokedexapp.presentation.pokedex_list

import com.example.pokedexapp.domain.model.Pokedex

data class PokedexListState(
    val isLoading: Boolean = false,
    val pokedex: List<Pokedex> = emptyList(),
    val error: String = ""
)