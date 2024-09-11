package com.example.Basketball_game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel:ViewModel() {
    var _text = MutableLiveData<String>()
    val text: MutableLiveData<String> get() = _text
}