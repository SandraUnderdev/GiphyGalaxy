package com.example.giphygalaxy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.giphygalaxy.data.repository.GiphyRepo

class GiphyViewModelFactory(private val giphyRepo: GiphyRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GiphyGalaxyViewModel::class.java)) {
            return GiphyGalaxyViewModel(giphyRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
