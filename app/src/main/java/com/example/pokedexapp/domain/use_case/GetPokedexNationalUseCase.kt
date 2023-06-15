package com.example.pokedexapp.domain.use_case

import com.example.pokedexapp.domain.repository.PokedexRepository
import javax.inject.Inject

class GetPokedexNationalUseCase @Inject constructor(
    private val repository: PokedexRepository
) {

    operator fun invoke()  {


    }

}