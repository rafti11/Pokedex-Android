package com.example.pokedexapp.data.remote.dto

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toUpperCase
import com.example.pokedexapp.common.Tools
import com.example.pokedexapp.domain.model.Pokemon
import com.example.pokedexapp.domain.model.Stats
import com.google.gson.annotations.SerializedName

data class PokemonDTO(
    val id: Int,
    val name: String,
    val weight: Int,
    val stats: List<Stat>,
    val types: List<Type>,
    val height: Int,
    val image: String

)

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int,
    @SerializedName("stat")
    val statDetails: StatDetails
)

data class StatDetails(
    val name: String,
    val url: String
)

data class Type(
    val slot: Int,
    @SerializedName("type")
    val typeDetails: TypeDetails
)

data class TypeDetails(
    val name: String,
    val url: String
)

fun PokemonDTO.toPokemon() : Pokemon {
    return Pokemon(
        id = id,
        name = name,
        weight = weight,
        height = height,
        image = Tools().getImageFromID(id),
        types = types.map {
            it.typeDetails.name
        },
        stats = pokemonDTOStatsToStats(stats)
    )
}

private fun pokemonDTOStatsToStats(data: List<Stat>) : Stats {
    var hp = 0
    var attack = 0
    var defense = 0
    var spAtk = 0
    var spDef = 0
    var speed = 0

    data.map {
        when(it.statDetails.name) {
            "hp" -> hp = it.baseStat
            "attack" -> attack = it.baseStat
            "defense" -> defense = it.baseStat
            "special-attack" -> spAtk = it.baseStat
            "special-defense" -> spDef = it.baseStat
            "speed" -> speed = it.baseStat
        }
    }

    return Stats(hp = hp, attack = attack, defense = defense, spAtk = spAtk, spDef = spDef, speed = speed)
}