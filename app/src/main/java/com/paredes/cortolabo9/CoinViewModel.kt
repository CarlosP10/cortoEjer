package com.paredes.cortolabo9

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CoinViewModel(private val app:Application):AndroidViewModel(app){

    private val repository: CoinRepository

    init {
        val coinDao=CoinDB.getInstance(app).coinDao()
        val gitCoinService = CoinService.getCoinService()
        repository= CoinRepository(coinDao,gitCoinService)

    }

    private suspend fun insert(coin:CoinEntity)=repository.insert(coin)

    /*fun retrieveRepo(user:String)= viewModelScope.launch {
        this@GitHubRepoViewModel.nuke()
        val response=repository.retrieveReposAsync(user).await()

        //Evalua y decide dependiendo del estado de la respuesta obtenida

        if(response.isSuccessful) with(response){

            //Inserta toda la lista en la base de datos
            this.body()?.forEach {
                this@GitHubRepoViewModel.insert(it)
            }

        }else with(response){

            kotlin.io.println(this.code())
            when(this.code()){
                //Aqui pueden evaluarse todos los codigos HTTP
                404->{
                    //Muestra un estado de error en caso no encuentre el usuario
                    android.widget.Toast.makeText(app, "Usuario no encontrado", android.widget.Toast.LENGTH_LONG).show()
                }
            }

        }
    }*/

    fun getAll(): LiveData<List<CoinEntity>> {
        return repository.getAll()
    }

    private suspend fun nuke()= repository.nuke()
}