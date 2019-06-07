package com.paredes.cortolabo9

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Deferred
import retrofit2.Response

class CoinRepository (private val coinDao:CoinEntityDao,private val coinService:CoinService){

    @WorkerThread
    suspend fun insert (coin:CoinEntity){
        coinDao.insert(coin)
    }

    fun getAll():LiveData<List<CoinEntity>>{
        return coinDao.getAllCoins()
    }

    @WorkerThread
    suspend fun nuke(){
        return coinDao.nukeTable()
    }

    /*fun retrieveReposAsync(user:String): Deferred<Response<List<CoinEntity>>> {
        return coinService.algosituviera
    }*/
}