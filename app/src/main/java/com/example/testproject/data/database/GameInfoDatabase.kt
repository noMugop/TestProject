package com.example.testproject.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testproject.data.database.model.GameInfoDbModel

@Database(entities = [GameInfoDbModel::class], version = 5, exportSchema = false)
abstract class GameInfoDatabase: RoomDatabase() {

    companion object {

        private var db: GameInfoDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "gameInfo.db"

        fun getInstance(application: Application): GameInfoDatabase {

            db?.let { return it }

            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    application,
                    GameInfoDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun gameInfoDao(): GameInfoDao
}