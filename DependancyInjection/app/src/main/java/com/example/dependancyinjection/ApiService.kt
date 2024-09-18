package com.example.dependancyinjection

 import retrofit2.http.GET

interface ApiService {
    @GET("albums")
    suspend fun getAlbumList(): List<Album>
}