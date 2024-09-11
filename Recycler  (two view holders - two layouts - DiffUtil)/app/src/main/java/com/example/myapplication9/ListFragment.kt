package com.example.myapplication9

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication9.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var _binding: FragmentListBinding

    private lateinit var adapter: UserDataAdapter
    private val binding get() = _binding

    private val userDataList: MutableList<UserData> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        addItemToList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = UserDataAdapter {
            userDataList.remove(it.first)
            adapter.setUserList(userDataList)
        }

        // Set adapter to RecyclerView
        binding.mylist.layoutManager = GridLayoutManager(requireContext(),1)
        binding.mylist.adapter = adapter

        // Set user data to adapter
        adapter.setUserList(userDataList)

    }

    private fun addItemToList() {
        userDataList.apply {
            add(UserData("Loay Sherif", "1234567890", "LoaySherif@gmail.com" , 1 , 1))
            add(UserData("Omar Kareem", "1234567890", "OmarKareem@gmail.com", 2 , 2))
            add(UserData("Ahmed Essam", "1234567890", "AhmedEssam@gmail.com" , 3 , 1))
            add(UserData("Youssef Ahmed", "1234567890", "YoussefAhmed@gmail.com", 4 , 2))
            add(UserData("Nour Mohamed", "1234567890", "NourMohamed@gmail.com", 5 , 1))
            add(UserData("Yehia Mahmoud", "1234567890", "YehiaMahmoud@gmail.com", 6 , 2))
        }
    }


}
