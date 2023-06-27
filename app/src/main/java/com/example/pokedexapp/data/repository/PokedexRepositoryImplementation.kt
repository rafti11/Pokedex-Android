package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.remote.PokedexApi
import com.example.pokedexapp.data.remote.dto.EvolutionChainDTO
import com.example.pokedexapp.data.remote.dto.PokedexDTO
import com.example.pokedexapp.data.remote.dto.PokemonDTO
import com.example.pokedexapp.domain.repository.PokedexRepository
import javax.inject.Inject

class PokedexRepositoryImplementation @Inject constructor(
    private val api: PokedexApi
): PokedexRepository {

    override suspend fun getPokedexNational(): PokedexDTO {
        return  api.getPokedexNational()
    }

    override suspend fun getPokemonByID(id: Int): PokemonDTO {
        return api.getPokemonByID(id)
    }

    override suspend fun getEvolutionChainByID(id: Int): EvolutionChainDTO {
        return api.getEvolutionChainByID(id)
    }

}