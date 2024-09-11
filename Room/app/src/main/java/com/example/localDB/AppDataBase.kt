package com.example.localDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun getDao():UserDao
    companion object{
        private var instance:AppDataBase?=null
        fun getDataBase(context:Context):AppDataBase{
            return instance?: synchronized(this){
                val localInstance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,"user_database"
                ).fallbackToDestructiveMigration().build()
                instance=localInstance
                localInstance

            }
        }
    }
}
