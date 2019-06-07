package com.paredes.cortolabo9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CoinAdapter
    lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    private fun bind(){
        adapter= CoinAdapter(ArrayList())
        viewModel= ViewModelProviders.of(this).get(CoinViewModel::class.java)
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
