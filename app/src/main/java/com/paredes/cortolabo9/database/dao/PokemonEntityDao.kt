package com.paredes.cortolabo9.database.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.paredes.cortolabo9.database.entity.PokemonEntity

@Dao
interface PokemonEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemon")
    fun getAllCoins():LiveData<PagedList<PokemonEntity>>

    @Query("DELETE FROM pokemon")
    suspend fun nukeTable()
}