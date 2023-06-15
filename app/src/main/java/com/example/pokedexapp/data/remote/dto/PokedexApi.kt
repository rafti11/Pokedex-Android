package com.example.pokedexapp.data.remote.dto

import retrofit2.http.GET

interface PokedexApi {

    @GET("pokedex/1/")
    suspend fun getPokedexNational() : PokedexDTO
}