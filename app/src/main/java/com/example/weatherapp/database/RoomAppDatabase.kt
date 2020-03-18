package com.example.weatherapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.ui.detailscityweather.DetailedWeatherModel

@Database(entities = [DetailedWeatherModel::class], version = 1, exportSchema = false)
abstract class RoomAppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        private var INSTANCE: RoomAppDatabase? = null

        fun getAppDataBase(context: Context): RoomAppDatabase? {
            if (INSTANCE == null) {
                synchronized(RoomAppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, RoomAppDatabase::class.java, "database.save").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }

        const val DATABASE_NAME = "database.save"
    }
}