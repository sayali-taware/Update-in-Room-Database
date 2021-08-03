package com.example.roomdatabaseexample.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdatabaseexample.model.User

//Data access object which contains methods used for accessing the d/b

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)  //If there is new exactly the same user then we'll ignore that.
    suspend fun addUser(user: User)                  //suspend coz later we'll be using coroutines

    @Query("SELECT * FROM user_table ORDER BY id ASC")     //will return a list of user wrapped in live data
    fun readAllData(): LiveData<List<User>>                       //Live data is of type is list of users wrapped around live data object
}