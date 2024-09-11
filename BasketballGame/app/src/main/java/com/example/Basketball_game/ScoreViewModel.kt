package com.example.Basketball_game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    private var _score1 = MutableLiveData<Int>()
    val score1: MutableLiveData<Int> get() = _score1

    private var _score2 = MutableLiveData<Int>()
    val score2: MutableLiveData<Int> get() = _score2

    var _text = MutableLiveData<String>()
    val text: MutableLiveData<String> get() = _text
    init {
        _score1.value = 0
        _score2.value = 0
    }


    fun incrementScoreTeamOne() {
        val currentScore = _score1.value ?: 0
        _score1.value = currentScore + 1
    }

    fun incrementScoreTeamTwo() {
        val currentScore = _score2.value ?: 0
        _score2.value = currentScore + 1
    }

    fun checkWinner() {
        if (_score1.value!! > _score2.value!!) {
            _text.value = "Team 1 is the winner"
        }
        else if (_score1.value!! < _score2.value!!) {
            _text.value = "Team 2 is the winner"
        }
        else {
            _text.value = "It's a draw"
        }

    }
}