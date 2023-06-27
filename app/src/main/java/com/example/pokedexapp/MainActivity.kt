package com.example.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexapp.data.remote.dto.EvolutionChainDTO
import com.example.pokedexapp.di.AppModule
import com.example.pokedexapp.domain.model.EvolutionChain
import com.example.pokedexapp.domain.model.EvolutionChain2
import com.example.pokedexapp.domain.model.PokemonEvolution
import com.example.pokedexapp.presentation.Screen
import com.example.pokedexapp.presentation.pokedex_list.PokedexListScreen
import com.example.pokedexapp.presentation.pokedex_pokemon_details.PokedexPokemonDetailScreen
import com.example.pokedexapp.presentation.ui.theme.PokedexAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lifecycleScope.launch {

            // 67 eevee, 26 poliwag, mimrjr 57, vulpix 15, WURMPLE 135
            println("consul")
            val ret = AppModule.providePokedexRepository(AppModule.providePokemonApi()).getEvolutionChainByID(135)


//            ecDtoToEv(ret)
            evo2(ret)

        }

        setContent {





//            PokedexAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
////                    PokedexListScreen()
////                    PreviewPK()
//
//                    val navController = rememberNavController()
//
//                    NavHost(
//                        navController = navController,
//                        startDestination = Screen.PokedexListScreen.route
//                    ) {
//                        composable(
//                            route = Screen.PokedexListScreen.route
//                        ){
//                            PokedexListScreen(navController = navController)
//                        }
//
//                        composable(
//                            route = Screen.PokemonDetailsScreen.route + "/{pokemonID}"
//                        ){
//                            PokedexPokemonDetailScreen()
//                        }
//                    }
//                }
//            }
        }
    }
}

private fun ecDtoToEv(ev: EvolutionChainDTO) {

    val arr = ArrayList<EvolutionChain>()

    var initialPokemon = ev.chain.species.name
    var nextPokemon = ""
    ev.chain.evolvesTo.map {
        nextPokemon = it.species.name
        arr.add(EvolutionChain(initialPokemon, listOf(nextPokemon)))

        if (it.evolvesTo.isNotEmpty()) {
            it.evolvesTo.map { it2 ->
                initialPokemon = nextPokemon
                nextPokemon = it2.species.name
                arr.add(EvolutionChain(initialPokemon, listOf(nextPokemon)))

            }
        }
    }

    println(arr)

    arr.forEach {
        println(it.name  + " evolves to: ")
        it.evolves.forEach{ it2 ->
            println(it2)
        }

    }
}

private fun evo2(ev: EvolutionChainDTO) {

    val arr = ArrayList<PokemonEvolution>()

    var arr2 = ArrayList<String>()

    val arr3 = ArrayList<ArrayList<String>>()

    val initial = ev.chain.species.name

    var next = ""

    ev.chain.evolvesTo.forEach{
        next = it.species.name


        arr2.add(initial)

        arr2.add(next)



        val ev = it.evolvesTo.isNotEmpty()

        if (ev) {

            it.evolvesTo.forEach{it2 ->



                var arr4 = ArrayList<String>()
                arr2.forEach { s ->
                    arr4.add(s)
                }

                arr4.add(it2.species.name)
                println(arr4)
                arr3.add(arr4)
                arr4 = ArrayList()

            }
            arr2 = ArrayList()
        } else {
            arr3.add(arr2)
            arr2 = ArrayList()
        }

    }

    println(arr3)


}