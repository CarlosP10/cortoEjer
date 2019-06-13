package com.paredes.cortolabo9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.paredes.adapter.PokemonAdapter
import com.paredes.cortolabo9.viewModel.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: PokemonAdapter
    lateinit var viewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    private fun bind(){
        adapter= PokemonAdapter(ArrayList())
        viewModel= ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        rv_repos.apply {
            adapter=this@MainActivity.adapter
            layoutManager= LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })
        btn_repo.setOnClickListener {
            viewModel.getAll()
        }
    }
}
