package com.example.giphygalaxy.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphygalaxy.data.model.Data
import com.example.giphygalaxy.data.repository.GiphyRepo
import kotlinx.coroutines.launch

class GiphyGalaxyViewModel(
    private val giphyRepo: GiphyRepo
) : ViewModel() {

    private val _gifs = MutableLiveData<List<Data>>()
    val gifs: LiveData<List<Data>> = _gifs

    fun fetchTrendingGifs(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = giphyRepo.getData(apiKey)
                _gifs.value = response.data
                Log.e("#####", "Response received: ${response.data}")
            } catch (e: Exception) {
                Log.e("#####", "fetchTrendingGifs: $e")
            }

        }
    }
}