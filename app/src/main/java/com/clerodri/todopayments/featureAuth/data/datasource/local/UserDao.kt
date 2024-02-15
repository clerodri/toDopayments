package com.clerodri.todopayments.featureAuth.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Upsert
    suspend fun insertUser(user:User)

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id:Int): User

    @Delete
    suspend fun  deleteUser(user:User)

    @Query("SELECT * FROM users")
     fun getAllUsers(): List<User>
}