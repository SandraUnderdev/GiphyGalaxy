package com.example.giphygalaxy.data.repository


import com.example.giphygalaxy.data.model.Giphy
import com.example.giphygalaxy.data.remote.ApiService

class GiphyRepo(private val apiService: ApiService) {
    suspend fun getData(apiKey: String): Giphy  {
        return apiService.getTrendingGifs(apiKey)
    }
}
