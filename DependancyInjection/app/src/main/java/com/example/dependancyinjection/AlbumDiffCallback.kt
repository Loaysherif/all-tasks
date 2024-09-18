package com.example.dependancyinjection

import androidx.recyclerview.widget.DiffUtil

class AlbumDiffCallback(
    private val oldList: List<Album>,
    private val newList: List<Album>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // Compare albums by unique IDs
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // Compare all content fields (title, userId, etc.)
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}