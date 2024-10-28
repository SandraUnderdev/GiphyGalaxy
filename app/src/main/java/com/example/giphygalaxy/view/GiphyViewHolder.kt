package com.example.giphygalaxy.view

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphygalaxy.data.model.Data
import com.example.giphygalaxy.databinding.GiphyGalaxyListItemBinding

class GiphyViewHolder(
    private val binding: GiphyGalaxyListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(gif: Data) {
        binding.gifTitle.text = gif.title
        binding.gifUrl.text = gif.url
        Glide.with(binding.gifImage.context)
            .load(gif.images.original.url)
            .into(binding.gifImage)
    }
}