package com.example.pokedexapp.data.remote

import com.example.pokedexapp.data.remote.dto.PokedexListDTO
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PokemonGraphqlApi {

    @POST("v1beta")
    suspend fun getPokedexNational(@Body requestBody: RequestBody): PokedexListDTO

    @POST("v1beta")
    suspend fun getPokedexNational1(@Body requestBody: RequestBody): PokedexListDTO
}