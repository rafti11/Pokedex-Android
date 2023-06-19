package com.example.pokedexapp.common

class Tools {

    fun getImageFromID(id: Int) : String {
        val url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/"
        val extension = ".png"

        return when(id){
            in 1..9 -> url + "00" + id + extension
            in 10..99 -> url + "0" + id + extension
            else -> url + id + extension
        }
    }
}