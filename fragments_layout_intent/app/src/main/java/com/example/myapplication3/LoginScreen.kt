package com.example.myapplication3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication3.databinding.ActivityLoginScreenBinding
import com.example.myapplication3.databinding.ActivityMainBinding

class LoginScreen : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {ActivityLoginScreenBinding.inflate(layoutInflater)  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val name =intent.getStringExtra("name")
        val id =intent.getIntExtra("id", 0)
        val isMale = intent.getBooleanExtra("isMale" , false)

        binding.TV2.text="name=$name  id= $id  $isMale"

        }
    }
