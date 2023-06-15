package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.remote.dto.PokedexApi
import com.example.pokedexapp.data.remote.dto.PokedexDTO
import com.example.pokedexapp.domain.repository.PokedexRepository
import javax.inject.Inject

class PokedexRepositoryImplementation @Inject constructor(
    private val api: PokedexApi
): PokedexRepository {

    override suspend fun getPokedexNational(): PokedexDTO {
        return  api.getPokedexNational()
    }

}