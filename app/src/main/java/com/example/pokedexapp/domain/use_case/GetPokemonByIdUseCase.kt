package com.example.pokedexapp.domain.use_case

import com.example.pokedexapp.common.Resource
import com.example.pokedexapp.data.remote.dto.toPokemon
import com.example.pokedexapp.domain.model.Pokemon
import com.example.pokedexapp.domain.repository.PokedexRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonByIdUseCase @Inject constructor(
    private val repository: PokedexRepository
) {
    operator fun invoke(id: Int) : Flow<Resource<Pokemon>> = flow {

        try {
            emit(Resource.Loading())
            val data = repository.getPokemonByID(id).toPokemon()
            emit(Resource.Success(data))
        }catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "error PokemonUseCase"))
        }
    }
}