package com.example.giphygalaxy.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giphygalaxy.R
import com.example.giphygalaxy.data.remote.ApiClient
import com.example.giphygalaxy.data.repository.GiphyRepo
import com.example.giphygalaxy.databinding.ActivityMainBinding
import com.example.giphygalaxy.databinding.GiphyGalaxyListItemBinding
import com.example.giphygalaxy.viewmodel.GiphyGalaxyViewModel
import com.example.giphygalaxy.viewmodel.GiphyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GiphyGalaxyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding =
            ActivityMainBinding.inflate(layoutInflater) // Inflate the layout using ViewBinding.
        setContentView(binding.root)

        val giphyRepo = GiphyRepo(ApiClient.apiService)
        val factory = GiphyViewModelFactory(giphyRepo)
        viewModel = ViewModelProvider(this, factory).get(GiphyGalaxyViewModel::class.java)


        val adapter = GiphyAdapter(emptyList())

        binding.giphyRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.giphyRecyclerView.adapter = adapter

        viewModel.gifs.observe(this) { gifs ->
            adapter.updateData(gifs)
        }
        val apiKey = "60W1K46ZG0EMHSKlJ3D4lwv6JMhoBWPC"
        viewModel.fetchTrendingGifs(apiKey)
    }
}
