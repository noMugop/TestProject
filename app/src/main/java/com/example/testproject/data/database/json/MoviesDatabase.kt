package com.example.testproject.data.database.json

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testproject.data.database.json.model.MovieDbModel

@Database(entities = [MovieDbModel::class], version = 1, exportSchema = false)
abstract class MoviesDatabase: RoomDatabase() {

    companion object {

        private var db: MoviesDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "movieInfo.db"

        fun getInstance(application: Application): MoviesDatabase {

            db?.let { return it }

            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    application,
                    MoviesDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun gameInfoDao(): MoviesDao
}