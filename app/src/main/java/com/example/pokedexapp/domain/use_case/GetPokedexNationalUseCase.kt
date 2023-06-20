package com.example.pokedexapp.domain.use_case

import com.example.pokedexapp.common.Resource
import com.example.pokedexapp.data.remote.dto.toPokemonEntryList
import com.example.pokedexapp.domain.model.PokedexEntry
import com.example.pokedexapp.domain.repository.PokemonGraphqlRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import javax.inject.Inject

class GetPokedexNationalUseCase @Inject constructor(
    private val repository: PokemonGraphqlRepository
) {
    operator fun invoke() : Flow<Resource<List<PokedexEntry>>> = flow {


        val jsonObject = JSONObject()
        jsonObject.put("query", "query samplePokeAPIquery{pokemon_v2_pokemon{id, name, types:pokemon_v2_pokemontypes{type:pokemon_v2_type{name}}}}")
        jsonObject.put("operationName", "samplePokeAPIquery")
        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        try {
            emit(Resource.Loading())
            val data = repository.getPokedexNational(requestBody).toPokemonEntryList()
            emit(Resource.Success(data))
        }catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "error NationalUseCase"))
        }
    }
}