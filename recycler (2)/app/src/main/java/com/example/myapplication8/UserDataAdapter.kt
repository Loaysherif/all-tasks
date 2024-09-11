package com.example.myapplication8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication8.databinding.FragmentListBinding
import com.example.myapplication8.databinding.ItemLayoutBinding

class UserDataAdapter(
    val userDataList:List<UserData>,
    val onItemClick:(UserData)->Unit,

):RecyclerView.Adapter<UserDataAdapter.UserDataHolder>() {
    inner class UserDataHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bindData(userData: UserData)
        {
            binding.user = userData
            binding.root.setOnClickListener()
            {
                onItemClick(userData)
            }

        //binding.name.text = userData.name
        //binding.phone.text = userData.phone
        //binding.mail.text = userData.mail
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserDataHolder(binding)
    }

    override fun getItemCount() = userDataList.size

    override fun onBindViewHolder(holder: UserDataHolder, position: Int) {
        holder.bindData(userDataList[position])
//        holder.binding.name.text= userDataList[position].name
//        holder.binding.phone.text= userDataList[position].phone
//        holder.binding.mail.text= userDataList[position].mail


    }



}