package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.remote.PokemonGraphqlApi
import com.example.pokedexapp.data.remote.dto.PokedexListDTO
import com.example.pokedexapp.domain.repository.PokemonGraphqlRepository
import okhttp3.RequestBody
import javax.inject.Inject

class PokemonGraphqlRepositoryImplementation @Inject constructor(
    private val api: PokemonGraphqlApi
) : PokemonGraphqlRepository{

    override suspend fun getPokedexNational(requestBody: RequestBody): PokedexListDTO {
        return api.getPokedexNational(requestBody)
    }
}