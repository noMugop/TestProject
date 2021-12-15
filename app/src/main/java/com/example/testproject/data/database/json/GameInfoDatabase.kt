package com.example.testproject.data.database.json

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testproject.data.database.json.model.GameInfoDbModel
import com.example.testproject.data.database.json.model.converter.Converters

@Database(entities = [GameInfoDbModel::class], version = 2, exportSchema = false)
abstract class GameInfoDatabase : RoomDatabase() {

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
                ).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun gameInfoDao(): GameInfoDao
}