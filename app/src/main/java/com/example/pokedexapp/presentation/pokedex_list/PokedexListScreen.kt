package com.example.pokedexapp.presentation.pokedex_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedexapp.presentation.pokedex_list.components.PokedexEntryItem
import com.example.pokedexapp.presentation.pokedex_list.components.PokedexEntryItem2

@Composable
fun PokedexListScreen(
    viewModel: PokedexListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.pokedex){
                println(it)
                PokedexEntryItem2(pokedex = it)
            }
        }

    }
}