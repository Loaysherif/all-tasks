package com.example.myapplication8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication8.databinding.FragmentListBinding


class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    val userDataList:MutableList<UserData> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        addItemToList()
        return binding.root

}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mylist.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = UserDataAdapter(userDataList){
                useritem ->
                userDataList.remove(useritem)
                adapter?.notifyItemRemoved(userDataList.indexOf(useritem))

//                findNavController().navigate(R.id.detailsFragment, bundleOf(
//                    "user" to useritem
//                ))
            }
        }
    }
    fun addItemToList(){
//        userDataList.clear()
        userDataList.add(UserData("Loay Sherif", "1234567890", "LoaySherif@gmail.com"))
        userDataList.add(UserData("Omar Kareem", "1234567890", "OmarKareem@gmail.com"))
        userDataList.add(UserData("Ahmed Essam", "1234567890", "AhmedEssam@gmail.com"))
        userDataList.add(UserData("Youssef Ahmed", "1234567890", "YoussefAhmed@gmail.com"))
        userDataList.add(UserData("Nour Mohamed", "1234567890", "NourMohamed@gmail.com"))
        userDataList.add(UserData("Yehia Mahmoud", "1234567890", "YehiaMahmoud@gmail.com"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        userDataList.clear()
    }
}