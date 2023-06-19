package com.example.pokedexapp.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val image: String,
    val types: List<String>
)