package com.paredes.cortolabo9.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name:String,

    @field:Json(name = "weight")
    val weight:Int,

    @field:Json(name = "base_experience")
    val base_experience:Int
)