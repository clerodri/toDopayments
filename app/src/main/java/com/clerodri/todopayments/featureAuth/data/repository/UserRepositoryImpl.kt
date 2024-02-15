package com.clerodri.todopayments.featureAuth.data.repository

import com.clerodri.todopayments.featureAuth.data.datasource.local.User
import com.clerodri.todopayments.featureAuth.data.datasource.local.UserDao
import com.clerodri.todopayments.featureAuth.domain.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(private val dao: UserDao) : UserRepository {
    override suspend fun insertUser(user: User) {
        dao.insertUser(user)
    }

    override suspend fun deleteUser(user: User) {
        dao.deleteUser(user)
    }

    override suspend fun getUserById(id: Int): User? {
       return dao.getUserById(id)
    }

    override fun getAllUsers(): List<User>{
        return dao.getAllUsers()
    }
}