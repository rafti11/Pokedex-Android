package com.example.pokedexapp.domain.use_case

import com.example.pokedexapp.common.Resource
import com.example.pokedexapp.data.remote.dto.toPokedex
import com.example.pokedexapp.domain.model.Pokedex
import com.example.pokedexapp.domain.repository.PokedexRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokedexNationalUseCase @Inject constructor(
    private val repository: PokedexRepository
) {
    operator fun invoke() : Flow<Resource<List<Pokedex>>> = flow {

        try {
            emit(Resource.Loading())
            val data = repository.getPokedexNational().toPokedex()
            emit(Resource.Success(data))
        }catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "error NationalUseCase"))
        }
    }
}