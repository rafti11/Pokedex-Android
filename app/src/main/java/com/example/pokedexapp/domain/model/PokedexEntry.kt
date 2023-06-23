package com.example.pokedexapp.domain.model

data class PokedexEntry(
    val id: Int,
    val name: String,
    val image: String,
    val types: List<String>
)