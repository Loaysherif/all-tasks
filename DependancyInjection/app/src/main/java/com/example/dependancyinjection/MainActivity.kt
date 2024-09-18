// MainActivity.kt
package com.example.dependancyinjection

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependancyinjection.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: AlbumViewModel by viewModels()
    private lateinit var adapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        adapter = AlbumAdapter(emptyList()) // Initialize with an empty list
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Observe data from ViewModel
        viewModel.album.observe(this, Observer { albumList ->
            adapter.updateAlbumList(albumList) // Update the list instead of creating a new adapter
        })
        binding.text.setOnClickListener{
            setLocalization(this, "ar")
        }
    }
    fun setLocalization(context: Context, languageCode:String){
        val local = Locale(languageCode)
        Locale.setDefault(local)
        val res = context.resources
        val config =resources.configuration
        config.setLocale(local)
       res.updateConfiguration(config, res.displayMetrics)
        recreate()
    }
}










