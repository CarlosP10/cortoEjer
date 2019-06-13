package com.paredes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.paredes.cortolabo9.R
import com.paredes.cortolabo9.database.entity.PokemonEntity
import kotlinx.android.synthetic.main.repo_cardview.view.*

class PokemonAdapter (var pokemon:List<PokemonEntity>):RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = pokemon.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pokemon[position])
    }

    fun updateList(newPokemons:List<PokemonEntity>){
        pokemon=newPokemons
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(pokemon: PokemonEntity) = with(itemView) {
            Glide.with(itemView.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ pokemon.id+".png")
                .placeholder(R.drawable.ic_launcher_background)
                .into(image_poke)
            experience_poke.text = pokemon.base_experience.toString()
            name_pokemon.text = pokemon.name
            weight_poke.text = pokemon.weight.toString()
        }

    }

}