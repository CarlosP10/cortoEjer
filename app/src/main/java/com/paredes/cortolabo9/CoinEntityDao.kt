package com.paredes.cortolabo9

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CoinEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(coin:CoinEntity)

    @Query("SELECT * FROM coin")
    fun getAllCoins():LiveData<List<CoinEntity>>

    @Query("DELETE FROM coin")
    suspend fun nukeTable()
}