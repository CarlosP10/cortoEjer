package com.paredes.cortolabo9.database.service

import androidx.paging.PagedList
import com.paredes.cortolabo9.database.entity.PokemonEntity
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name:String): Deferred<Response<PagedList<PokemonEntity>>>

}