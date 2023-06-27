package com.example.pokedexapp.domain.repository

import com.example.pokedexapp.data.remote.dto.EvolutionChainDTO
import com.example.pokedexapp.data.remote.dto.PokedexDTO
import com.example.pokedexapp.data.remote.dto.PokemonDTO

interface PokedexRepository {

    suspend fun getPokedexNational() : PokedexDTO
    suspend fun getPokemonByID(id: Int) : PokemonDTO
    suspend fun getEvolutionChainByID(id: Int) : EvolutionChainDTO
}