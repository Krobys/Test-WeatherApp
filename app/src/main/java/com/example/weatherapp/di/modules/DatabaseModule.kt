package com.example.weatherapp.di.modules

import android.content.Context
import androidx.room.Room
import com.example.weatherapp.database.RoomAppDatabase
import com.example.weatherapp.database.RoomAppDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideDatabase(context: Context): RoomAppDatabase {
        return Room.databaseBuilder(context,
                RoomAppDatabase::class.java,
                DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideWeatherDao(database: RoomAppDatabase) = database.weatherDao()

}