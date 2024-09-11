package com.example.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("select * from user_table order by id asc")
     fun getAllUsers(): LiveData<List<User>>
    @Insert
    suspend fun insertUser(user:User)
    @Update
    suspend fun updateUser(user:User)
    @Delete
    suspend fun deleteUser(user:User)

}