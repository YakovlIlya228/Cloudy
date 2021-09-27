package com.example.cloudy.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cloudy.source.DataConfig
import com.example.cloudy.source.DataConfig.DATABASE_VERSION
import com.example.cloudy.source.db.country.CountryDao
import com.example.cloudy.source.db.country.CountryDb


@Database(
    entities = [CountryDb::class],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = DataConfig.DATABASE_NAME
    }

    abstract fun countryDao(): CountryDao
}