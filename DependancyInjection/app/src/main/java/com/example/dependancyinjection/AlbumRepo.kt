package com.example.dependancyinjection

import javax.inject.Inject

class AlbumRepo @Inject constructor(
    val apiService: ApiService
) {
    suspend fun getALbumList():List<Album>{
        return apiService.getAlbumList()
    }
}