package com.example.pokedexapp.presentation.pokedex_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.common.Resource
import com.example.pokedexapp.domain.use_case.GetPokedexNationalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokedexListViewModel @Inject constructor(
private val getPokedexNationalUseCase: GetPokedexNationalUseCase
): ViewModel() {


    private var _state = mutableStateOf(PokedexListState())
    val state: State<PokedexListState> = _state



    init {
        getPokedexNational()
    }

    private fun getPokedexNational() {

        getPokedexNationalUseCase().onEach { result ->

            when(result) {
                is Resource.Loading -> {
                    println("natio lo")
                    _state.value = PokedexListState(isLoading = true)
                }
                is Resource.Success -> {
                    println("natio su")
                    _state.value = PokedexListState(pokedex = result.data ?: emptyList())
                    println("size: " + state.value.pokedex.size)
                }
                is Resource.Error -> {
                    println("natio err")
                    _state.value  = PokedexListState(error = "state error")
                }
            }
        }.launchIn(viewModelScope)
    }
}