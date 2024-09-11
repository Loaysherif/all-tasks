package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    fun validateInput() {
        val name = binding.NameEt.et1.text.toString()
        val email = binding.emailEt.et1.text.toString()
        val password = binding.passwordEt.et2.text.toString()
        val nameRegex = Regex("^[a-zA-Z\\s]+\$") // Only letters and spaces
        val emailRegex =
            Regex("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") // Simple email validation
        val passwordRegex =
            Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$") // Minimum 6 characters, 1 uppercase, 1 lowercase, and 1 number
        when {
            name.isEmpty() -> {
                Toast.makeText(this, "Name is required", Toast.LENGTH_SHORT).show()
            }

            !nameRegex.matches(name) -> {
                Toast.makeText(this, "Invalid name format", Toast.LENGTH_SHORT).show()
            }

            email.isEmpty() -> {
                Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show()
            }

            !emailRegex.matches(email) -> {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
            }

            password.isEmpty() -> {
                Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
            }

            !passwordRegex.matches(password) -> {
                Toast.makeText(
                    this,
                    "Password must be at least 6 characters, with 1 uppercase, 1 lowercase, and 1 number",
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> {
                Toast.makeText(this, "Sign Up successful", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.NameEt.et1.hint = "Name"
        binding.emailEt.et1.hint = "Email"
        binding.passwordEt.et2.hint = "Password"
        binding.passwordEt.et2.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        binding.tv1.text = "Sign Up"
        binding.btn1.text = "Sign Up"
        binding.btn1.setOnClickListener {
            validateInput()
        }

    }
}