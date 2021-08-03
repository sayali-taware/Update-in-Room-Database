package com.example.roomdatabaseexample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabaseexample.model.User
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

//represent d/b. Contains d/b holder & serves as the main access point for the underlying connection to your app's persisted, relational data

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object{                               // everything in this companion object will be visible to other classes
        @Volatile                                   //rights to the field are made immediately visible to other threads
        private var INSTANCE: UserDatabase? = null  //user database is made singleton class which means user d/b will have only one instance of our class

        @InternalCoroutinesApi
        fun getDatabase(context: Context): UserDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){                      //if this is not null then it means that our instance already exists we're returning it
                return tempInstance
            }
            synchronized(this){                  //everything within this block will be protected from concurrent execution by multiple threads
                val instance = Room.databaseBuilder(   //if instance is null here it will create new instance of room d/b
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance                   //assigned instance with new instance
                return  instance
            }
        }
    }
}