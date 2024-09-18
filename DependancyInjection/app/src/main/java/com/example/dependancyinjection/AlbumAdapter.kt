// AlbumAdapter.kt
package com.example.dependancyinjection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dependancyinjection.databinding.ItemAlbumBinding

class AlbumAdapter(
    private var albumList: List<Album>
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(private val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {
        // Bind the album data to the views
        fun bind(album: Album) {
            binding.albumTitle.text = album.title
            binding.albumId.text = "Album ID: ${album.id}"
            binding.userId.text = "User ID: ${album.userId}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albumList[position]
        holder.bind(album)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }
    fun updateAlbumList(newAlbumList: List<Album>) {
        val diffCallback = AlbumDiffCallback(albumList, newAlbumList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        albumList = newAlbumList
        diffResult.dispatchUpdatesTo(this)
    }
}
