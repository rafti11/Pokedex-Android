package com.example.pokedexapp.domain.repository

import com.example.pokedexapp.data.remote.dto.PokedexDTO

interface PokedexRepository {

    suspend fun getPokedexNational() : PokedexDTO
}