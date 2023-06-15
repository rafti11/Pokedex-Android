package com.example.pokedexapp.di

import com.example.pokedexapp.data.remote.PokedexApi
import com.example.pokedexapp.data.repository.PokedexRepositoryImplementation
import com.example.pokedexapp.domain.repository.PokedexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonApi(): PokedexApi {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokedexApi::class.java)
    }

    @Provides
    @Singleton
    fun providePokedexRepository(api: PokedexApi): PokedexRepository {
        return PokedexRepositoryImplementation(api)
    }
}