package com.example.roomdatabaseexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabaseexample.data.UserDatabase
import com.example.roomdatabaseexample.repository.UserRepository
import com.example.roomdatabaseexample.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class UserViewModel(application: Application): AndroidViewModel(application) {      //AndroidViewModel is different from viewmodel coz it contains application reference

     val  readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)                 //dispatchers.io lets to run code in background thread
        }
    }
}