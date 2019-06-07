package com.paredes.cortolabo9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.repo_cardview.view.*

class CoinAdapter (var coin:List<CoinEntity>):RecyclerView.Adapter<CoinAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return coin.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(coin[position])
    }

    fun updateList(newCoins:List<CoinEntity>){
        newCoins.forEach{
            println("QUe pex")
        }
        this.coin=newCoins
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(coin: CoinEntity) = with(itemView) {
            this.repo_name.text=coin.name
        }

    }

}