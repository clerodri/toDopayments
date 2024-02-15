package com.clerodri.todopayments.featureAuth.data.datasource.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    val firstName:String,
    val lastName : String,
    val email:String,
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
