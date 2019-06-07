package com.paredes.cortolabo9

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "coin")
data class CoinEntity(
    @PrimaryKey
    @field:Json(name = "_id")
    val id: String,

    @field:Json(name = "name")
    val name:String,

    @field:Json(name = "country")
    val country:String,

    @field:Json(name = "year")
    val year:Int
)