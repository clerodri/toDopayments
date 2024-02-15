package com.clerodri.todopayments.featureAuth.domain


import com.clerodri.todopayments.featureAuth.data.datasource.local.User
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    suspend fun insertUser(user:User)
    suspend fun deleteUser(user:User)

    suspend fun getUserById(id:Int):User?

    fun getAllUsers(): List<User>

}