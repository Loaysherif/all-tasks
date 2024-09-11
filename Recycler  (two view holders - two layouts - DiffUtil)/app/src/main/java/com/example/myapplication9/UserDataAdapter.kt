package com.example.myapplication9

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication9.databinding.ItemLayoutOneBinding
import com.example.myapplication9.databinding.ItemLayoutTwoBinding

class UserDataAdapter(
    val onItemDeleted: (Pair<UserData, Int>) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val userList: MutableList<UserData> = mutableListOf()

    fun setUserList(list: List<UserData>) {
        val myDifUtil= MyDiffUtil(userList,list)
        val difResult = DiffUtil.calculateDiff(myDifUtil)
        userList.clear()
        userList.addAll(list)
        difResult.dispatchUpdatesTo(this)
    }

    companion object {
        const val HolderTypeOne = 1
        const val HolderTypeTwo = 2
    }

    inner class ViewHolderOne(val binding: ItemLayoutOneBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(userData: UserData) {
            binding.user = userData
            binding.imageView.load("https://loremflickr.com/320/240"){
                crossfade(true)
            }
            binding.delete.setOnClickListener {
                onItemDeleted(Pair(userData, adapterPosition))
            }
        }
    }

    inner class ViewHolderTwo(val binding: ItemLayoutTwoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(userData: UserData) {
            binding.user = userData
            binding.edit.setOnClickListener{
                binding.view.setBackgroundColor(Color.RED)
            }
            binding.delete.setOnClickListener {
                onItemDeleted(Pair(userData, adapterPosition))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HolderTypeOne -> {
                val binding = ItemLayoutOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderOne(binding)
            }
            HolderTypeTwo -> {
                val binding = ItemLayoutTwoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderTwo(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userData = userList[position]
        when (holder) {
            is ViewHolderOne -> holder.bindData(userData)
            is ViewHolderTwo -> holder.bindData(userData)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(userList[position].type){
            1 -> HolderTypeOne
            2-> HolderTypeTwo
            else -> HolderTypeOne
        }
    }

    override fun getItemCount(): Int = userList.size


}
