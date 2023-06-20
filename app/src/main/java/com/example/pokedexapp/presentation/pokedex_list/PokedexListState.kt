package com.example.pokedexapp.presentation.pokedex_list

import com.example.pokedexapp.domain.model.Pokedex
import com.example.pokedexapp.domain.model.PokedexEntry

data class PokedexListState(
    val isLoading: Boolean = false,
    val pokedex: List<PokedexEntry> = emptyList(),
    val error: String = ""
)