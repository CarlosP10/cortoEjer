package com.paredes.cortolabo9.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.paredes.cortolabo9.database.dao.PokemonEntityDao
import com.paredes.cortolabo9.database.entity.PokemonEntity
import com.paredes.cortolabo9.database.service.PokeApi
import kotlinx.coroutines.Deferred
import retrofit2.Response

class PokemonRepository (private val pokemonDao: PokemonEntityDao, private val coinService: PokeApi){

    @WorkerThread
    suspend fun insert (pokemon: PokemonEntity){
        pokemonDao.insert(pokemon)
    }

    fun getAll():LiveData<PagedList<PokemonEntity>>{
        return pokemonDao.getAllCoins()
    }

    @WorkerThread
    suspend fun nuke(){
        return pokemonDao.nukeTable()
    }

    fun retrieveReposAsync(name:String): Deferred<Response<PagedList<PokemonEntity>>> {
        return coinService.getPokemon(name)
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 500
        private const val DATABASE_PAGE_SIZE = 20
    }
}