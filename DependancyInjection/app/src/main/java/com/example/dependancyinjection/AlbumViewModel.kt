package com.example.dependancyinjection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
   private val albumRepo: AlbumRepo
): ViewModel() {
    init {
        fetchALbums()
    }
    private val _albumList = MutableLiveData<List<Album>>()
    val album:LiveData<List<Album>> = _albumList

    fun  fetchALbums(){
        viewModelScope.launch {
            val response = albumRepo.getALbumList()
            _albumList.postValue(response)
        }
    }
}