package com.paredes.cortolabo9

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val GITHUB_BASE_URL="https://apicoin.herokuapp.com/coin"

interface CoinService {

/*    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user:String): Deferred<Response<List<CoinEntity>>>
*/

    companion object{
        var INSTANCE: CoinService? = null

        fun getCoinService():CoinService{
            if (INSTANCE != null){
                return INSTANCE!!
            }else{
                INSTANCE = Retrofit
                    .Builder()
                    .baseUrl(GITHUB_BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
                    .create(CoinService::class.java)
                return INSTANCE!!
            }
        }
    }
}
