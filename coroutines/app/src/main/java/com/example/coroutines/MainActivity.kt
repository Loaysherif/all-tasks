package com.example.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val job = Job()
        val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

        coroutineScope.launch {
            var name1: String = ""
            var name2: String = ""
            var name3: String = ""
            var name4: String = ""

            val job1 = coroutineScope.launch {
                name1 = getName1()
            }
            job1.join()
            Log.i("job", "job1: $name1 + time: ${System.currentTimeMillis()}")

            val job2 = coroutineScope.launch {
                name2 = getName2()
            }
            job2.join()
            Log.i("job", "job2: $name2 + time: ${System.currentTimeMillis()}")

            val job3 = coroutineScope.async {
                name3 = getName3()
                Log.i("job", "job3: $name3 + time: ${System.currentTimeMillis()}")
            }

            val job4 = coroutineScope.async {
                for (i in 1..10) {
                    delay(1000)
                    Log.i("job4", "$i")
                }
                name4 = getName4()
                Log.i("job", "job4: $name4 + time: ${System.currentTimeMillis()}")
            }

            runBlocking {
                delay(4000)
            }
            job4.cancel()
        }
    }

    suspend fun getName1(): String {
        delay(1000)
        return "Name1"
    }

    suspend fun getName2(): String {
        delay(2000)
        return "Name2"
    }

    suspend fun getName3(): String {
        delay(1500)
        return "Loay"
    }

    suspend fun getName4(): String {
        delay(2500)
        return "Omar"
    }
}