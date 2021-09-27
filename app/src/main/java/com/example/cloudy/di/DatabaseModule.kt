package com.example.cloudy.di

import androidx.room.Room
import com.example.cloudy.source.db.AppDatabase
import com.example.cloudy.source.db.DbRepository
import com.example.cloudy.source.db.DbRepositoryImp
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDatabase>().countryDao()
    }

    single<DbRepository> {
        DbRepositoryImp(get())
    }
}