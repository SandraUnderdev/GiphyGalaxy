package com.example.giphygalaxy.data.model

data class Giphy(
    val `data`: List<Data>,
    val meta: Meta,
    val pagination: Pagination
)