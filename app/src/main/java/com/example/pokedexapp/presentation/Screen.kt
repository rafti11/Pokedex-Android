package com.example.pokedexapp.presentation

sealed class Screen(val route: String) {
    object PokedexListScreen : Screen("pokedex_list_screen")
    object PokemonDetailsScreen : Screen("pokemon_details_screen")
}
