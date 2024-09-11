package com.example.myapplication3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication3.databinding.FragmentFourBinding
import com.example.myapplication3.databinding.FragmentThreeBinding
import com.example.myapplication3.databinding.FragmentTwoBinding

class Fragment_Four : Fragment() {
    lateinit var binding: FragmentFourBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}