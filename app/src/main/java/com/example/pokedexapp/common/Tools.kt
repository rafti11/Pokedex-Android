package com.example.pokedexapp.common

import androidx.compose.ui.graphics.Color
import com.example.pokedexapp.R
import kotlin.reflect.typeOf

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

    fun getColorFromPokemonType(type: String) : Int {
        return when(type){
            "bug" -> R.color.Bug
            "dark" -> R.color.Dark
            "dragon" -> R.color.Dragon
            "electric" -> R.color.Electric
            "fairy" -> R.color.Fairy
            "fighting" -> R.color.Fighting
            "fire" -> R.color.Fire
            "flying" -> R.color.Flying
            "ghost" -> R.color.Ghost
            "grass" -> R.color.Grass
            "ground" -> R.color.Ground
            "ice" -> R.color.Ice
            "normal" -> R.color.Normal
            "poison" -> R.color.Poison
            "psychic" -> R.color.Psychic
            "rock" -> R.color.Rock
            "steel" -> R.color.Steel
            "water" -> R.color.Water
            else -> {R.color.white}
        }
    }
}