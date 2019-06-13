package com.paredes.cortolabo9.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.paredes.cortolabo9.database.dao.PokemonEntityDao
import com.paredes.cortolabo9.database.entity.PokemonEntity


@Database(entities = [PokemonEntity::class],version = 1, exportSchema = false)
abstract class PokemonDB :RoomDatabase(){
    abstract fun coinDao(): PokemonEntityDao

    companion object{
        @Volatile
        private var INSTANCE: PokemonDB? = null

        fun getInstance(
            context: Context
        ): PokemonDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, PokemonDB::class.java, "Pokemon_Database")
                    .build()
                INSTANCE =instance
                return instance
            }

        }
    }
}