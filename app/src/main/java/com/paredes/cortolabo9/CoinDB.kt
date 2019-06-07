package com.paredes.cortolabo9

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CoinEntity::class],version = 1, exportSchema = false)
abstract class CoinDB :RoomDatabase(){
    abstract fun coinDao():CoinEntityDao

    companion object{
        @Volatile
        private var INSTANCE: CoinDB? = null

        fun getInstance(
            context: Context
        ): CoinDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, CoinDB::class.java, "Coin_Database")
                    .build()
                INSTANCE=instance
                return instance
            }

        }
    }
}