package com.example.myapplication6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication6.databinding.ItemLayoutBinding

class UserDataAdapter(
    private val userList: List<User>,
    private val onItemClick: (User) -> Unit // Pass the click listener via the constructor
) : RecyclerView.Adapter<UserDataAdapter.UserDataHolder>() {

    override fun getItemCount() = userList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserDataHolder(binding)
    }

    override fun onBindViewHolder(holder: UserDataHolder, position: Int) {
        holder.bind(userList[position])
    }

    inner class UserDataHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.name.text = user.name
            binding.email.text = user.email
            binding.phone.text = user.phone
            binding.root.setOnClickListener {
                onItemClick(user) // Use the click listener passed in the constructor
            }
        }
    }
}
