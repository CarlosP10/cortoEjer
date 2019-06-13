package com.paredes.cortolabo9.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.paredes.cortolabo9.database.PokemonDB
import com.paredes.cortolabo9.database.entity.PokemonEntity
import com.paredes.cortolabo9.database.service.PokemonService
import com.paredes.cortolabo9.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(private val app:Application):AndroidViewModel(app){

    private val repository: PokemonRepository

    init {
        val coinDao= PokemonDB.getInstance(app).coinDao()
        repository= PokemonRepository(coinDao, PokemonService.pokeApi)

    }

    private val scope = CoroutineScope(Dispatchers.IO)

    private val movieslist = MutableLiveData<MutableList<PokemonEntity>>()

    private suspend fun insert(pokemon: PokemonEntity)=repository.insert(pokemon)

    fun fetchPokemon(name: String){
        scope.launch {
            val response=repository.retrieveReposAsync(name).await()
            if(response.isSuccessful) with(response){
                when(this.code()){
                    200->movieslist.postValue(this.body())
                }
            }else{
                Toast.makeText(app, "Ocurrio un error", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun getAll(): LiveData<PagedList<PokemonEntity>> {
        return repository.getAll()
    }

    private suspend fun nuke()= repository.nuke()
}