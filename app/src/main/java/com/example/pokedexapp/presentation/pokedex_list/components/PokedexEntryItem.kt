package com.example.pokedexapp.presentation.pokedex_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.pokedexapp.domain.model.Pokedex

@Composable
fun PokedexEntryItem(pokedex: Pokedex) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(model = pokedex.sprite, contentDescription = null)
        Text(text = pokedex.id.toString())
        Text(text = pokedex.name)
    }
}