package com.example.myapplication6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication6.databinding.ViewlistBinding

class ViewList : Fragment() {
    private lateinit var binding: ViewlistBinding
    private val listUser: MutableList<User> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addUserToList()
        binding.mylist.layoutManager = LinearLayoutManager(requireContext())
        binding.mylist.adapter = UserDataAdapter(listUser) { user ->
            // Handle item click
        }
    }

    private fun addUserToList() {
        listUser.add(User("Ahmed0", "ahmed0@gmail.com", "123456"))
        listUser.add(User("Ahmed1", "ahmed1@gmail.com", "123456"))
        listUser.add(User("Ahmed2", "ahmed2@gmail.com", "123456"))
        listUser.add(User("Ahmed3", "ahmed3@gmail.com", "123456"))
        listUser.add(User("Ahmed4", "ahmed4@gmail.com", "123456"))
        listUser.add(User("Ahmed5", "ahmed5@gmail.com", "123456"))
        listUser.add(User("Ahmed6", "ahmed6@gmail.com", "123456"))
    }
}
