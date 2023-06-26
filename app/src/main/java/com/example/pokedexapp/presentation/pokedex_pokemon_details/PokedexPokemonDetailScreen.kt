package com.example.pokedexapp.presentation.pokedex_pokemon_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.pokedexapp.R
import com.example.pokedexapp.common.Tools
import com.example.pokedexapp.domain.model.Pokemon
import com.example.pokedexapp.domain.model.Stats
import com.example.pokedexapp.presentation.pokedex_list.PokedexListViewModel

@Composable
fun PokedexPokemonDetailScreen(
    viewModel: PokedexPokemonDetailsViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)) {

        Column {
            PokemonImage(state.pokemon)
            PokemonName(name = state.pokemon.name)
            PokemonType(state.pokemon)
            PokemonStats(stats = state.pokemon.stats)

        }

    }
}

@Composable
fun PokemonImage(pokemon: Pokemon) {
//    Image(
//        painter = painterResource(id = R.drawable._01),
//        contentDescription = null,
//        modifier = Modifier
//            .padding(30.dp)
//            .background(colorResource(id = Tools().getColorFromPokemonType(pokemon.types[0])))
//            .fillMaxWidth()
//            .border(2.dp, Color.Black)
//    )
//
    AsyncImage(
        model = pokemon.image,
        contentDescription = null,
        modifier = Modifier
            .padding(30.dp)
            .background(colorResource(id = Tools().getColorFromPokemonType(pokemon.types[0])))
            .fillMaxWidth()
            .border(2.dp, Color.Black)
    )
}

@Composable
fun PokemonName(name: String) {
    Text(
        text = name,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun PokemonType(pokemon: Pokemon) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(pokemon.types.size) {
            val type = pokemon.types[it]
            Text(
                text = type,
                modifier = Modifier
                    .background(
                        colorResource(id = Tools().getColorFromPokemonType(type)),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(top = 2.dp, bottom = 2.dp, start = 5.dp, end = 5.dp)
            )
        }
    }
}

@Composable
fun PokemonStats(stats: Stats) {

    Column {
        LinearBar(number = stats.hp)
        LinearBar(number = stats.attack)
        LinearBar(number = stats.defense)
        LinearBar(number = stats.spAtk)
        LinearBar(number = stats.spDef)
        LinearBar(number = stats.speed)
    }
}

@Composable
fun LinearBar(number: Int) {
    LinearProgressIndicator(
        modifier = Modifier
            .height(15.dp)
            .fillMaxWidth(),
        progress = Tools().intToFloatPercent(number),
        color = Color.Cyan
    )
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewPK() {
//
//    val pokemon = Pokemon(
//        id = 1, name = "bulbasaur", height = 11, weight = 12, image = "ffff",
//        types = listOf("grass", "poison"),
//        stats = Stats(55, 70, 23, 41, 15, 62))
//
//    PokedexPokemonDetailScreen(pokemon = pokemon)
//
//}