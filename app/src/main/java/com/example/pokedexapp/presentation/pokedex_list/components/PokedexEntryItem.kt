package com.example.pokedexapp.presentation.pokedex_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokedexapp.R
import com.example.pokedexapp.common.Tools
import com.example.pokedexapp.domain.model.Pokedex
import com.example.pokedexapp.domain.model.PokedexEntry
import com.example.pokedexapp.domain.model.Pokemon

@Composable
fun PokedexEntryItem(pokedexEntry: PokedexEntry) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row {
            PokemonImage(pokedexEntry.image)

            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()
                    .size(1.dp)
            )

            PokemonData(pokedexEntry)
        }
    }
}

@Composable
fun PokemonImage(image: String) {
    AsyncImage(
        model = image,
        contentDescription = null,
        modifier = Modifier.background(Color.White)
    )
}

@Composable
fun PokemonData(pokedexEntry: PokedexEntry) {
    Column(
        modifier = Modifier
            .background(colorResource(id = Tools().getColorFromPokemonType(pokedexEntry.types[0])))
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        PokemonNumber(pokedexEntry.id)
        PokemonName(pokedexEntry.name)
        PokemonType(pokedexEntry.types)
    }
}

@Composable
fun PokemonNumber(id: Int) {
    Text(
        text = "#${id}",
        fontSize = 20.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .width(75.dp)
            .background(
                Color.Black, shape = RoundedCornerShape(
                    topEnd = 15.dp,
                    topStart = 0.dp,
                    bottomEnd = 15.dp,
                    bottomStart = 0.dp
                )
            )
    )
}

@Composable
fun PokemonName(name: String) {
    Text(
        text = name.uppercase(),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PokemonType(types: List<String>) {
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 50.dp, end = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {

        items(types.size){
            Text(text = types[it], fontStyle = FontStyle.Italic)
        }
    }
}


@Preview
@Composable
fun PrevPara() {
    val pokedex = PokedexEntry(
        id = 25,
        name = "pikachu",
        image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",
        types = listOf("fire")
    )

    PokedexEntryItem(pokedex)
}