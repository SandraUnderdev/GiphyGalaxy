package com.example.giphygalaxy.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.giphygalaxy.data.model.Data
import com.example.giphygalaxy.databinding.GiphyGalaxyListItemBinding

class GiphyAdapter(
    private var gifs : List<Data>
) : RecyclerView.Adapter<GiphyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiphyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GiphyGalaxyListItemBinding.inflate(inflater, parent, false)
        return GiphyViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return gifs.size
    }

    override fun onBindViewHolder(holder: GiphyViewHolder, position: Int) {
        val currentGif = gifs[position]
        holder.bind(currentGif)
    }

    fun updateData(newData: List<Data>) {
       gifs = newData
        notifyDataSetChanged()
    }

}