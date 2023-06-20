package com.example.pokedexapp.di

import com.example.pokedexapp.data.remote.PokedexApi
import com.example.pokedexapp.data.remote.PokemonGraphqlApi
import com.example.pokedexapp.data.repository.PokedexRepositoryImplementation
import com.example.pokedexapp.data.repository.PokemonGraphqlRepositoryImplementation
import com.example.pokedexapp.domain.repository.PokedexRepository
import com.example.pokedexapp.domain.repository.PokemonGraphqlRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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

    @Provides
    @Singleton
    fun PokemonGraphqlApi(): PokemonGraphqlApi {
        return Retrofit.Builder()
            .baseUrl("https://beta.pokeapi.co/graphql/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(PokemonGraphqlApi::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonGraphqlRepository(api: PokemonGraphqlApi): PokemonGraphqlRepository {
        return PokemonGraphqlRepositoryImplementation(api)
    }


}