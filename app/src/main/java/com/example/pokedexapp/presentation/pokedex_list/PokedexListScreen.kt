package com.example.pokedexapp.presentation.pokedex_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokedexapp.presentation.Screen
import com.example.pokedexapp.presentation.pokedex_list.components.PokedexEntryItem


@Composable
fun PokedexListScreen(
    navController: NavController,
    viewModel: PokedexListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(state.pokedex){
                println(it)
                PokedexEntryItem(
                    pokedexEntry = it,
                    itemClick = { pk ->
                        navController.navigate(Screen.PokemonDetailsScreen.route + "/${pk.id}")
                })
            }
        }

    }
}