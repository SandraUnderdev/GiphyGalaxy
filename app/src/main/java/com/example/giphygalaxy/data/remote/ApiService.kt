package com.example.giphygalaxy.data.remote

import com.example.giphygalaxy.data.model.Giphy
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/gifs/trending")
    suspend fun getTrendingGifs(
        @Query("api_key") apiKey: String
    ) :Giphy
}