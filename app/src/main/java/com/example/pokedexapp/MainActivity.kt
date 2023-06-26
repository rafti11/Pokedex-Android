package com.example.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexapp.presentation.Screen
import com.example.pokedexapp.presentation.pokedex_list.PokedexListScreen
import com.example.pokedexapp.presentation.pokedex_pokemon_details.PokedexPokemonDetailScreen
import com.example.pokedexapp.presentation.ui.theme.PokedexAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    PokedexListScreen()
//                    PreviewPK()

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.PokedexListScreen.route
                    ) {
                        composable(
                            route = Screen.PokedexListScreen.route
                        ){
                            PokedexListScreen(navController = navController)
                        }

                        composable(
                            route = Screen.PokemonDetailsScreen.route + "/{pokemonID}"
                        ){
                            PokedexPokemonDetailScreen()
                        }
                    }
                }
            }
        }
    }
}