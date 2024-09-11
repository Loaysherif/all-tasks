package com.example.myapplication9

import java.io.Serializable

data class UserData(
    val name:String,
    val phone:String,
    val mail:String,
    val id:Int,
    val type:Int
):Serializable
