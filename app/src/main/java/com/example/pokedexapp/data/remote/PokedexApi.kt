package com.example.pokedexapp.data.remote

import com.example.pokedexapp.data.remote.dto.PokedexDTO
import com.example.pokedexapp.data.remote.dto.PokemonDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApi {

    @GET("pokedex/1/")
    suspend fun getPokedexNational() : PokedexDTO

    @GET("pokemon/{id}")
    suspend fun getPokemonByID(@Path("id") id: Int) : PokemonDTO
}