package com.example.pokedexapp.presentation.pokedex_pokemon_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.common.Resource
import com.example.pokedexapp.domain.model.Pokemon
import com.example.pokedexapp.domain.model.Stats
import com.example.pokedexapp.domain.use_case.GetPokedexNationalUseCase
import com.example.pokedexapp.domain.use_case.GetPokemonByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokedexPokemonDetailsViewModel @Inject constructor(
    private val getPokemonByIdUseCase: GetPokemonByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {


    private var _state = mutableStateOf(PokedexPokemonState())
    val state: State<PokedexPokemonState> = _state



    init {
        savedStateHandle.get<String>("pokemonID")?.let {

            println("keeeeeeee $it")
            getPokemon(it.toInt())
        }
    }

    private fun getPokemon(pokemonID: Int) {

        getPokemonByIdUseCase(pokemonID).onEach { result ->

            when(result) {
                is Resource.Loading -> {
                    println("pok lo")
                    _state.value = PokedexPokemonState(isLoading = true)
                }
                is Resource.Success -> {
                    println("pok su")
                    _state.value = PokedexPokemonState(pokemon = result.data ?: PokedexPokemonState().pokemon)
                    println("poke: " + state.value)
                }
                is Resource.Error -> {
                    println("pok err")
                    _state.value  = PokedexPokemonState(error = "state error")
                }
            }
        }.launchIn(viewModelScope)
    }
}