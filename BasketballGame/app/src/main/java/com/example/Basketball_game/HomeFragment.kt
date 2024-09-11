package com.example.Basketball_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myapplication10.R
import com.example.myapplication10.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewmodel: ScoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }
   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       viewmodel.score1.observe(viewLifecycleOwner,Observer{
           binding.tvTeam1Score.text=it.toString()
       })
       viewmodel.score2.observe(viewLifecycleOwner, Observer{
           binding.tvTeam2Score.text=it.toString()
       })
       binding.btnIncreaseTeam1.setOnClickListener{
           viewmodel.incrementScoreTeamOne()
       }
       binding.btnIncreaseTeam2.setOnClickListener{
           viewmodel.incrementScoreTeamTwo()
       }
       binding.btnReset.setOnClickListener{
           viewmodel.score1.value=0
           viewmodel.score2.value=0
       }
       binding.btnFinalResult.setOnClickListener{
           viewmodel.checkWinner()
           findNavController().navigate(R.id.action_homeFragment_to_twoFragment)
       }
    }

}