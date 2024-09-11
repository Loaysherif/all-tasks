package com.example.localDB

import androidx.lifecycle.LiveData

class UserRepo(private val userDao: UserDao) {
    val allUser: LiveData<List<User>> =userDao.getAllUsers()
    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }
    suspend fun updateUser(user: User){
        userDao.insertUser(user)
    }
    suspend fun deleteUser(user: User){
        userDao.insertUser(user)
    }
}