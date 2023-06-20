package com.example.pokedexapp.presentation.pokedex_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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

//@Composable
//fun PokedexEntryItem(pokedex: Pokedex) {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        AsyncImage(model = pokedex.sprite, contentDescription = null)
//        Text(text = pokedex.id.toString())
//        Text(text = pokedex.name)
//    }
//}

@Preview
@Composable
fun PokedexEntryItem() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(15.dp))
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable._01),
            contentDescription = null,
            modifier = Modifier.background(Color.White)
        )
        Divider(
            color = Color.Black,
            modifier = Modifier
                .fillMaxHeight()
                .size(1.dp)
        )

        Column(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Text(
                text = "#1000",
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
            Text(
                text = "bulbashur",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth()
            )

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
                .background(Color.Red),
            horizontalArrangement = Arrangement.SpaceBetween) {

                Text(text = "grass")

                Text(text = "poison")
            }

        }
    }
}

@Composable
fun PokedexEntryItem2(pokedex: PokedexEntry) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(15.dp))
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = pokedex.image,
            contentDescription = null,
            modifier = Modifier.background(Color.White)
        )
        Divider(
            color = Color.Black,
            modifier = Modifier
                .fillMaxHeight()
                .size(1.dp)
        )

        Column(
            modifier = Modifier
                .background(colorResource(id = Tools().getColorFromPokemonType(pokedex.types[0])))
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Text(
                text = "#${pokedex.id}",
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
            Text(
                text = pokedex.name.uppercase(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth()
            )

            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
                .background(Color.Red),
                horizontalArrangement = Arrangement.SpaceBetween) {

                items(pokedex.types.size){

                    Text(text = pokedex.types[it])
                }


            }

        }
    }
}