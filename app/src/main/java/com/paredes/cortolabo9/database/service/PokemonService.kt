package com.paredes.cortolabo9.database.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.paredes.cortolabo9.database.entity.PokemonEntity
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val GITHUB_BASE_URL="https://pokeapi.co/api/v2/pokemon/"
//?offset=1&limit=806
object PokemonService{

        fun retrofit(): Retrofit = Retrofit
                    .Builder()
                    .baseUrl(GITHUB_BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()

                val pokeApi:PokeApi = retrofit().create(PokeApi::class.java)
}


