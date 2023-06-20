package com.example.pokedexapp.domain.repository

import com.example.pokedexapp.data.remote.dto.PokedexListDTO
import okhttp3.RequestBody

interface PokemonGraphqlRepository {
    suspend fun getPokedexNational(requestBody: RequestBody) : PokedexListDTO
}