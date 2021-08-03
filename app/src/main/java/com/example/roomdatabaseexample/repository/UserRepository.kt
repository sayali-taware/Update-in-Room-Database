package com.example.roomdatabaseexample.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabaseexample.data.UserDao
import com.example.roomdatabaseexample.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}